package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CheckingDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;

import java.util.List;

public interface ICheckingController {
    void saveChecking(CheckingDTO checkingDTO);
    List<Checking> getCheckings();

    Money getBalance(Long id);
}
