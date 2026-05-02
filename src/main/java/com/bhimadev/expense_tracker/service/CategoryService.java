package com.bhimadev.expense_tracker.service;


import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.CategoryRequest;
import com.bhimadev.expense_tracker.dto.CategoryResponse;
import com.bhimadev.expense_tracker.entity.Category;
import com.bhimadev.expense_tracker.entity.User;
import com.bhimadev.expense_tracker.repository.CategoryRepository;
import com.bhimadev.expense_tracker.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    UserRepository userRepository;

    public CategoryResponse addCategory(CategoryRequest request,String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Category category =new Category(
        request.name(),
        request.type(),
        user
        );
       Category savedCategory = categoryRepository.save(category);
        return CategoryResponse.fromEntity(savedCategory);
       
    }
    
}
