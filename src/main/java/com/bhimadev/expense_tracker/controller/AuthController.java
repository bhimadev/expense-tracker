package com.bhimadev.expense_tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhimadev.expense_tracker.dto.AuthResponse;
import com.bhimadev.expense_tracker.dto.LoginRequest;
import com.bhimadev.expense_tracker.dto.RegisterRequest;
import com.bhimadev.expense_tracker.payload.ApiResponse;
import com.bhimadev.expense_tracker.payload.ResponseHandler;
import com.bhimadev.expense_tracker.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
        @Valid @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseHandler.success(null, authService.register(registerRequest));
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseHandler.success(null, authService.login(loginRequest));
    }
}
