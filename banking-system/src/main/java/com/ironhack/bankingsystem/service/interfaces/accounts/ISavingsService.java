package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Savings;

import java.util.List;

public interface ISavingsService {
    Savings saveSavings(Savings savings);
    List<Savings> getSavings();
}
