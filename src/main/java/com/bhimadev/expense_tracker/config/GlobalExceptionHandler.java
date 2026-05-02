package com.bhimadev.expense_tracker.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEmail(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid email or password"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, fe ->
                        fe.getDefaultMessage() != null ? fe.getDefaultMessage() : "invalid"));
        return ResponseEntity.badRequest().body(errors);
    }

    // Missing or invalid JSON body

    @ExceptionHandler(HttpMessageNotReadableException.class)

    public ResponseEntity<Map<String, Object>> handleInvalidBody() {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", 400);

        response.put("message", "Request body is missing or invalid");

        return ResponseEntity.badRequest().body(response);

    }

    // Authentication issue

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)

    public ResponseEntity<Map<String, Object>> handleAuth() {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", 401);

        response.put("message", "Authentication required");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

    }

    // Fallback

    @ExceptionHandler(Exception.class)

    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", 500);

        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }
}
