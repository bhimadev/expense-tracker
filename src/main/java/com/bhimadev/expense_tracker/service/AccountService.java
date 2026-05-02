package com.bhimadev.expense_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.AccountAddRquest;
import com.bhimadev.expense_tracker.dto.AccountResponse;
import com.bhimadev.expense_tracker.entity.Account;
import com.bhimadev.expense_tracker.entity.User;
import com.bhimadev.expense_tracker.repository.AccountRepository;
import com.bhimadev.expense_tracker.repository.UserRepository;

@Service
public class AccountService {
    AccountRepository accountRepository;
    UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

   public AccountResponse addAccount(AccountAddRquest accountAddRquest, String email) {
    User user = userRepository.findByEmail(email).orElseThrow();
    Account account = new Account(user, accountAddRquest.accountName(), accountAddRquest.accountType(), accountAddRquest.balance());
    Account account1=accountRepository.save(account);
    return AccountResponse.fromWithUser(account1);

   }

   public List<AccountResponse> getAccounts(String email) {
    User user = userRepository.findByEmail(email).orElseThrow();
    return accountRepository.findByUser(user)
            .stream()
            .map(AccountResponse::fromWithUser)
            .toList();
   }
       
}
