package com.javaguides.banking_app.service.impl;

import com.javaguides.banking_app.dto.AccountDto;
import com.javaguides.banking_app.entity.Account;
import com.javaguides.banking_app.mapper.AccountMapper;
import com.javaguides.banking_app.repository.AccountRepository;
import com.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
