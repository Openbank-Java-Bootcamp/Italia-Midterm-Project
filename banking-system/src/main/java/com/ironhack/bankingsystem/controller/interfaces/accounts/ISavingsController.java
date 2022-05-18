package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Savings;

import java.util.List;

public interface ISavingsController {
    void saveSavings(Savings savings);
    List<Savings> getSavings();
}
