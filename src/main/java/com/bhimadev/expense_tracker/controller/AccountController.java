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
import com.bhimadev.expense_tracker.entity.Account;
import com.bhimadev.expense_tracker.entity.User;
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
    public ResponseEntity<ApiResponse<List<Account>>> index(@AuthenticationPrincipal UserDetails userDetails) {
    System.out.println("Authenticated user: " + userDetails.getUsername());
       List<Account> accounts = accountService.getAccounts(userDetails.getUsername());
        return ResponseHandler.success(null, accounts);
    }
@PostMapping
    public ResponseEntity<ApiResponse<Account>> store(@Valid @RequestBody AccountAddRquest request, @AuthenticationPrincipal UserDetails userDetails) {
        Account account = accountService.addAccount(request, userDetails.getUsername());
        
        return ResponseHandler.created("Account created successfully",account);
    
 }
}
