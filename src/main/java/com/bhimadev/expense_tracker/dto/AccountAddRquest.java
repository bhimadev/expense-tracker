package com.bhimadev.expense_tracker.dto;

import java.math.BigDecimal;

import com.bhimadev.expense_tracker.entity.AccountType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountAddRquest(
    @NotBlank(message = "Account name is required")
    String accountName,
    @NotNull(message = "Account type is required")
    AccountType accountType,
    @NotNull(message = "Balance is required")
    BigDecimal balance) {
    
}
