package com.ironhack.bankingsystem.controller.interfaces.users;

import com.ironhack.bankingsystem.DTO.AccountToAccountHolderDTO;
import com.ironhack.bankingsystem.DTO.userDTOs.AccountHolderDTO;
import com.ironhack.bankingsystem.models.users.AccountHolder;

import java.util.List;

public interface IAccountHolderController {
    void saveAccountHolder(AccountHolderDTO accountHolderDTO);
    List<AccountHolder> getAccountHolders();

//    void addAccountToHolder(AccountToAccountHolderDTO accountToAccountHolderDTO);
}
