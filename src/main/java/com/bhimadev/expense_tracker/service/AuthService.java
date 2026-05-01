package com.bhimadev.expense_tracker.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.AuthResponse;
import com.bhimadev.expense_tracker.dto.LoginRequest;
import com.bhimadev.expense_tracker.dto.RegisterRequest;
import com.bhimadev.expense_tracker.entity.User;
import com.bhimadev.expense_tracker.repository.UserRepository;

import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new IllegalArgumentException("Email already registered: " + registerRequest.email());
        }

        User user = new User(registerRequest.name(), registerRequest.email(), passwordEncoder.encode(registerRequest.password()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
    public AuthResponse login(LoginRequest loginRequest) {
 authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );
        System.out.println("Authentication successful for: " + loginRequest.email());
       User user = userRepository.findByEmail(loginRequest.email()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
