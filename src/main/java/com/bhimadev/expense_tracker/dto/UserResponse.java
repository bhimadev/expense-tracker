package com.bhimadev.expense_tracker.dto;

import com.bhimadev.expense_tracker.entity.Account;
import com.bhimadev.expense_tracker.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

    }
}

