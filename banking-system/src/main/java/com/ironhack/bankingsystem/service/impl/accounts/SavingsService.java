package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.SavingsDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ISavingsController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Savings;
import com.ironhack.bankingsystem.repository.accounts.SavingsRepository;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ISavingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavingsService implements ISavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;


    public Savings saveSavings(SavingsDTO savingsDTO) {

        var accountHolder = accountHolderRepository.findById(savingsDTO.getPrimaryOwnerId());
        if (accountHolder.isPresent()) {

            Savings savings = new Savings(savingsDTO.getBalance(),
                    accountHolderRepository.findById(savingsDTO.getPrimaryOwnerId()).get(),
                    accountHolderRepository.findById(savingsDTO.getSecondaryOwnerId()).get(),
                    savingsDTO.getSecretKey(), savingsDTO.getMinimumBalance(), savingsDTO.getInterestRate());
            log.info("Saving new Savings Account {} inside of the database", savings.getId());
            return savingsRepository.save(savings);

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id doesn't exist.");
        }
    }

    public List<Savings> getSavings() {
        log.info("Fetching all Savings Accounts");
        return savingsRepository.findAll();
    }

    public Money findBalanceById(Long id) {
        log.info("Fetching Account Balance");
        return savingsRepository.findById(id).get().getBalance();
    }
}
