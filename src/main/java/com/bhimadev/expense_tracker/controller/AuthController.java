package com.bhimadev.expense_tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhimadev.expense_tracker.dto.AuthResponse;
import com.bhimadev.expense_tracker.dto.LoginRequest;
import com.bhimadev.expense_tracker.dto.RegisterRequest;
import com.bhimadev.expense_tracker.jobs.EmailJobService;
import com.bhimadev.expense_tracker.payload.ApiResponse;
import com.bhimadev.expense_tracker.payload.ResponseHandler;
import com.bhimadev.expense_tracker.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    AuthService authService;
    private final EmailJobService emailJobService;
    public AuthController(AuthService authService, EmailJobService emailJobService) {
        this.authService = authService;
        this.emailJobService = emailJobService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
        @Valid @RequestBody RegisterRequest registerRequest
    ) {
        AuthResponse authResponse = authService.register(registerRequest);
        emailJobService.sendWelcomeEmail(registerRequest.email());
        return ResponseHandler.success(null, authResponse);
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseHandler.success(null, authService.login(loginRequest));
    }
}
