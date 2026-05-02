package com.bhimadev.expense_tracker.dto;

import com.bhimadev.expense_tracker.entity.CategoryType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record CategoryRequest(
    @NotBlank(message = "Category Name is required")
    String name, 
 @NotNull(message = "Category Type is required")    
  CategoryType type) {}