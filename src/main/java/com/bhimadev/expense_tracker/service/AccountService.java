package com.bhimadev.expense_tracker.service;

import org.springframework.stereotype.Service;

import com.bhimadev.expense_tracker.dto.AccountAddRquest;
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

   public Account addAccount(AccountAddRquest accountAddRquest, String email) {
    User user = userRepository.findByEmail(email).orElseThrow();
    Account account = new Account(user, accountAddRquest.accountName(), accountAddRquest.accountType(), accountAddRquest.balance());
    Account account1=accountRepository.save(account);
    return account1;

   }
       
}
