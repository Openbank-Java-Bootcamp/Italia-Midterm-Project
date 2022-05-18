package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.enums.AccountType;
import com.ironhack.bankingsystem.models.accounts.Account;

import java.util.List;

public interface IAccountService {
    Account saveAccount(Account account);
    List<Account> getAccounts();

//    void addTypeToAccount(Long accountId, AccountType accountType);
}
