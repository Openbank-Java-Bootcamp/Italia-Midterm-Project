package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Checking;

import java.util.List;

public interface ICheckingController {
    void saveChecking(Checking checking);
    List<Checking> getCheckings();
}
