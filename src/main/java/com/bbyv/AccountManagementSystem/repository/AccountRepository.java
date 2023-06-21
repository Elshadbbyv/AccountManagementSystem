package com.bbyv.AccountManagementSystem.repository;

import com.bbyv.AccountManagementSystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
