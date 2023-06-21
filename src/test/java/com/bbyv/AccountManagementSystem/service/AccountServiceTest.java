package com.bbyv.AccountManagementSystem.service;

import com.bbyv.AccountManagementSystem.dto.AccountCustomerDto;
import com.bbyv.AccountManagementSystem.dto.AccountDto;
import com.bbyv.AccountManagementSystem.dto.converter.AccountDtoConverter;
import com.bbyv.AccountManagementSystem.dto.request.CreateAccountRequest;
import com.bbyv.AccountManagementSystem.exception.CustomerNotFoundException;
import com.bbyv.AccountManagementSystem.model.Account;
import com.bbyv.AccountManagementSystem.model.Customer;
import com.bbyv.AccountManagementSystem.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AccountServiceTest {
    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerService customerService;
    private AccountDtoConverter converter;


    @BeforeEach
    public  void setUp(){
        accountRepository = mock(AccountRepository.class);
        customerService = mock(CustomerService.class);
        converter = mock(AccountDtoConverter.class);
        accountService = new AccountService(accountRepository,customerService,converter);
    }
    @Test
    public void testCraeteAccount_whenCustomerIdExist_shouldThrowCustomerNotFoundException(){
       // Account account  = new Account("id", BigDecimal.ZERO, LocalDateTime.now(), Set.of());



    }
}