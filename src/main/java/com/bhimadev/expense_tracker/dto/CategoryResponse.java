package com.bhimadev.expense_tracker.dto;

import com.bhimadev.expense_tracker.entity.Category;
import com.bhimadev.expense_tracker.entity.CategoryType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class CategoryResponse {
    private Long id;
    private String name;
    private CategoryType type;

    public static CategoryResponse fromEntity(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setType(category.getType());
        return response;
    }

}
