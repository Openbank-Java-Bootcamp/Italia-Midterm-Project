package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ISavingsController;
import com.ironhack.bankingsystem.models.accounts.Savings;
import com.ironhack.bankingsystem.repository.accounts.SavingsRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ISavingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavingsService implements ISavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public Savings saveSavings(Savings savings) {

        log.info("Saving new Savings Account {} inside of the database", savings.getId());
        return savingsRepository.save(savings);
    }

    public List<Savings> getSavings() {
        log.info("Fetching all Savings Accounts");
        return savingsRepository.findAll();
    }
}
