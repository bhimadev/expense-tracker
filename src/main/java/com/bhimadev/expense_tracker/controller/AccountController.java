package com.bhimadev.expense_tracker.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bhimadev.expense_tracker.dto.AccountAddRquest;
import com.bhimadev.expense_tracker.dto.AccountResponse;
import com.bhimadev.expense_tracker.entity.Account;
import com.bhimadev.expense_tracker.payload.ApiResponse;
import com.bhimadev.expense_tracker.payload.ResponseHandler;
import com.bhimadev.expense_tracker.service.AccountService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<AccountResponse>>> index(@AuthenticationPrincipal UserDetails userDetails) {
    System.out.println("Authenticated user: " + userDetails.getUsername());
       List<AccountResponse> accounts = accountService.getAccounts(userDetails.getUsername());
        return ResponseHandler.success(null, accounts);
    }
@PostMapping
    public ResponseEntity<ApiResponse<AccountResponse>> store(@Valid @RequestBody AccountAddRquest request, @AuthenticationPrincipal UserDetails userDetails) {
        AccountResponse account = accountService.addAccount(request, userDetails.getUsername());
        return ResponseHandler.created("Account created successfully",account);
    
 }
}
