package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.AccountDTO;
import com.ironhack.bankingsystem.models.accounts.Account;

import java.util.List;

public interface IAccountService {
//    Account saveAccount(AccountDTO accountDTO);
    List<Account> getAccounts();

}
