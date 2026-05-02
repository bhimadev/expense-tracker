package com.bhimadev.expense_tracker.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(
            String message,
            T data
    ) {
        return ResponseEntity.ok(
                ApiResponse.<T>builder()
                        .status(HttpStatus.OK.value())
                        .message(message)
                        .data(data)
                        .build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(
            String message,
            T data
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<T>builder()
                                .status(HttpStatus.CREATED.value())
                                .message(message)
                                .data(data)
                                .build()
                );
    }

    public static ResponseEntity<ApiResponse<Object>> error(
            HttpStatus status,
            String message,
            Object errors
    ) {
        return ResponseEntity.status(status)
                .body(
                        ApiResponse.builder()
                                .status(status.value())
                                .message(message)
                                .errors(errors)
                                .build()
                );
    }
}