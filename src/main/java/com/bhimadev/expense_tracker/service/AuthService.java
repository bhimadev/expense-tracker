package com.bhimadev.expense_tracker.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.AuthResponse;
import com.bhimadev.expense_tracker.dto.RegisterRequest;
import com.bhimadev.expense_tracker.entity.User;
import com.bhimadev.expense_tracker.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
}
