package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Account;

import java.util.List;

public interface IAccountController {
    //void saveAccount(Account account);
    List<Account> getAccounts();

}
