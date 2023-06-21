package com.bbyv.AccountManagementSystem.controller;

import com.bbyv.AccountManagementSystem.dto.AccountDto;
import com.bbyv.AccountManagementSystem.dto.request.CreateAccountRequest;
import com.bbyv.AccountManagementSystem.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@Valid  @RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
