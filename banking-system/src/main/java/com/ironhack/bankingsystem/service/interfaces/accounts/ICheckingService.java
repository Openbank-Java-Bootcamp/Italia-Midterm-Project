package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CheckingDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;

import java.util.List;

public interface ICheckingService {
    Checking saveChecking(CheckingDTO checkingDTO);
    List<Checking> getCheckings();

    Money findBalanceById(Long id);

}
