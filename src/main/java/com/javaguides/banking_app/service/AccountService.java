package com.javaguides.banking_app.service;

import com.javaguides.banking_app.dto.AccountDto;
import com.javaguides.banking_app.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
