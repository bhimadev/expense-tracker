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

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new IllegalArgumentException("Email already registered: " + registerRequest.email());
        }

        User user = new User(registerRequest.name(), registerRequest.email(), passwordEncoder.encode(registerRequest.password()));
        userRepository.save(user);
        return new AuthResponse("sample-token Rakashpal Singh");
    }
}
