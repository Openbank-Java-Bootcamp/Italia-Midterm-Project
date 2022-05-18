package com.ironhack.bankingsystem.controller.interfaces.users;

import com.ironhack.bankingsystem.models.users.AccountHolder;

import java.util.List;

public interface IAccountHolderController {
    void saveAccountHolder(AccountHolder accountHolder);
    List<AccountHolder> getAccountHolders();
}
