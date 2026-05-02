package com.bhimadev.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhimadev.expense_tracker.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
} 
