package com.javaguides.banking_app.controller;

import com.javaguides.banking_app.dto.AccountDto;
import com.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class Accountcontroller {

    private AccountService accountService;

    public Accountcontroller(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
}
