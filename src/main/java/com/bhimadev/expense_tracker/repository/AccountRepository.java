package com.bhimadev.expense_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhimadev.expense_tracker.entity.Account;
import com.bhimadev.expense_tracker.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
} 
