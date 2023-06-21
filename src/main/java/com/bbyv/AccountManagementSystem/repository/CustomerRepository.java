package com.bbyv.AccountManagementSystem.repository;

import com.bbyv.AccountManagementSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
