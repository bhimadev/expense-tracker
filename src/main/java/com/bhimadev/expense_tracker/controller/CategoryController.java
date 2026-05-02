package com.bhimadev.expense_tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhimadev.expense_tracker.dto.CategoryRequest;
import com.bhimadev.expense_tracker.dto.CategoryResponse;
import com.bhimadev.expense_tracker.entity.Category;
import com.bhimadev.expense_tracker.payload.ApiResponse;
import com.bhimadev.expense_tracker.payload.ResponseHandler;
import com.bhimadev.expense_tracker.service.CategoryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
   private final CategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> store(@Valid @RequestBody CategoryRequest request,@AuthenticationPrincipal UserDetails userDetails) {
CategoryResponse category = categoryService.addCategory(request,userDetails.getUsername());
        return  ResponseHandler.created("Category created successfully", category);
    }
}
