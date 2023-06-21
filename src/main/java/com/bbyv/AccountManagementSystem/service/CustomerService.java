package com.bbyv.AccountManagementSystem.service;

import com.bbyv.AccountManagementSystem.dto.CustomerDto;
import com.bbyv.AccountManagementSystem.dto.converter.CustomerDtoConverter;
import com.bbyv.AccountManagementSystem.exception.CustomerNotFoundException;
import com.bbyv.AccountManagementSystem.model.Customer;
import com.bbyv.AccountManagementSystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }
    protected Customer findById(String id){
        return customerRepository.findById(id).orElseThrow(
                ()-> new CustomerNotFoundException("invalid key"));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findById(customerId));
    }
}
