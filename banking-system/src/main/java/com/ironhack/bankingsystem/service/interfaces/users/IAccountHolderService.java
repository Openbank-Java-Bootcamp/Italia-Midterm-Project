package com.ironhack.bankingsystem.service.interfaces.users;

import com.ironhack.bankingsystem.DTO.userDTOs.AccountHolderDTO;
import com.ironhack.bankingsystem.models.users.AccountHolder;

import java.util.List;

public interface IAccountHolderService {

    AccountHolder saveAccountHolder(AccountHolderDTO accountHolderDTO);
    List<AccountHolder> getAccountHolders();

//    void addAccountToHolder(Long accountId, Long accountHolderId);
}
