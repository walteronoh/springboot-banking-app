package com.javaguides.banking_app.mapper;

import com.javaguides.banking_app.dto.AccountDto;
import com.javaguides.banking_app.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {

        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
