package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.SavingsDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Savings;

import java.util.List;

public interface ISavingsService {
    Savings saveSavings(SavingsDTO savingsDTO);
    List<Savings> getSavings();

    Money findBalanceById(Long id);

    void modifyBalance(Long id, AccountBalanceDTO accountBalanceDTO);

    void addInterest(Long id);

}
