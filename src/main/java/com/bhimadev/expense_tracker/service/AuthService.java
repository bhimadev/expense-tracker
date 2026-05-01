package com.bhimadev.expense_tracker.service;

import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.AuthResponse;
import com.bhimadev.expense_tracker.dto.RegisterRequest;
import com.bhimadev.expense_tracker.repository.UserRepository;

@Service
public class AuthService {
    UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
    return new AuthResponse("sample-token Rakashpal Singh");
}
}
