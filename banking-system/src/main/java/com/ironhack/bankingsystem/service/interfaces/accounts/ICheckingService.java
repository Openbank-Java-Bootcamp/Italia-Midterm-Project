package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Checking;

import java.util.List;

public interface ICheckingService {
    Checking saveChecking(Checking checking);
    List<Checking> getCheckings();

}
