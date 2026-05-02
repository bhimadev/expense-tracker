package com.bhimadev.expense_tracker.dto;
import com.bhimadev.expense_tracker.entity.Account;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
    private Long id;
    private String accountName;
    private String accountType;
    private Double balance;
    private UserResponse user;

    public AccountResponse(Long id, String accountName, String accountType, Double balance) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = balance;
        this.user = null;
    }
    public AccountResponse(Long id, String accountName, String accountType, Double balance,UserResponse user) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = balance;
        this.user = user;
    }


    // Entity -> DTO (without user)

    public static AccountResponse from(Account account) {

        return new AccountResponse(

                account.getId(),

                account.getAccountName(),

                account.getAccountType().name(),

                account.getBalance().doubleValue()

        );

    }

    // Entity -> DTO (with user)

    public static AccountResponse fromWithUser(Account account) {

        return new AccountResponse(

                account.getId(),

                account.getAccountName(),

                account.getAccountType().name(),

                account.getBalance().doubleValue(),

                UserResponse.from(account.getUser())

        );

    }


}
