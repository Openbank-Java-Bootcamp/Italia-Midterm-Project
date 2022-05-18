package com.ironhack.bankingsystem.service.interfaces.users;

import com.ironhack.bankingsystem.models.users.AccountHolder;

import java.util.List;

public interface IAccountHolderService {

    AccountHolder saveAccountHolder(AccountHolder accountHolder);
    List<AccountHolder> getAccountHolders();
}
