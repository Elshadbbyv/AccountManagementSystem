package com.bbyv.AccountManagementSystem.controller;

import com.bbyv.AccountManagementSystem.dto.CustomerDto;
import com.bbyv.AccountManagementSystem.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@Valid @PathVariable String customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

}
