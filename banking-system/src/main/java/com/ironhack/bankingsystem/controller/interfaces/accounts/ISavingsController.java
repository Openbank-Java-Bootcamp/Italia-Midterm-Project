package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.SavingsDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Savings;

import java.util.List;

public interface ISavingsController {
    void saveSavings(SavingsDTO savingsDTO);
    List<Savings> getSavings();

    Money getBalance(Long id);

}
