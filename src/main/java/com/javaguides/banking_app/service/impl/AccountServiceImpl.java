package com.javaguides.banking_app.service.impl;

import com.javaguides.banking_app.dto.AccountDto;
import com.javaguides.banking_app.entity.Account;
import com.javaguides.banking_app.mapper.AccountMapper;
import com.javaguides.banking_app.repository.AccountRepository;
import com.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist!"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist!"));
        double balance = account.getBalance();
        double total = balance + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist!"));
        double balance = account.getBalance();
        if(balance < amount) {
            throw new RuntimeException("You have insufficient balance!");
        }
        double total = balance - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map((Account ac) -> AccountMapper.mapToAccountDto(ac)).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist!"));
        accountRepository.deleteById(id);
    }
}
