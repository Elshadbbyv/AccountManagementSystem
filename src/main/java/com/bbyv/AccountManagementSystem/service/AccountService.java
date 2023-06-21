package com.bbyv.AccountManagementSystem.service;

import com.bbyv.AccountManagementSystem.dto.AccountDto;
import com.bbyv.AccountManagementSystem.dto.converter.AccountDtoConverter;
import com.bbyv.AccountManagementSystem.dto.request.CreateAccountRequest;
import com.bbyv.AccountManagementSystem.model.Account;
import com.bbyv.AccountManagementSystem.model.Customer;
import com.bbyv.AccountManagementSystem.model.Transaction;
import com.bbyv.AccountManagementSystem.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;



    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService, AccountDtoConverter converter
                          ) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;

    }
    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findById(createAccountRequest.getCustomerId());

        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0) {
            // = transactionService.initiateMoney(account,createAccountRequest.getInitialCredit());
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit() ,account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

}
