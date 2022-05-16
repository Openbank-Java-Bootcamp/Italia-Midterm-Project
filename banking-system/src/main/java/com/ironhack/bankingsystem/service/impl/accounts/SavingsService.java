package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ISavingsController;
import com.ironhack.bankingsystem.repository.accounts.SavingsRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ISavingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavingsService implements ISavingsService {

    @Autowired
    private SavingsRepository savingsRepository;
}
