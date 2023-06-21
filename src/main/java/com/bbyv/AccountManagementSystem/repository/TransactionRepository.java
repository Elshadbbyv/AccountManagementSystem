package com.bbyv.AccountManagementSystem.repository;

import com.bbyv.AccountManagementSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
