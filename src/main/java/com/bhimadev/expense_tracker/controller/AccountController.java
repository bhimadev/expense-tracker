package com.bhimadev.expense_tracker.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bhimadev.expense_tracker.dto.AccountAddRquest;
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
    
@PostMapping
    public ResponseEntity<ApiResponse<Account>> store(@Valid @RequestBody AccountAddRquest request, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(request);
        Account account = accountService.addAccount(request, userDetails.getUsername());
        
        return ResponseHandler.created("Account created successfully",account);
    
 }
}
