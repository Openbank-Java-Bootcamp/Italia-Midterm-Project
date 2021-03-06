package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.SavingsDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ISavingsController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id wasn't found.");
        }
    }

    public List<Savings> getSavings() {
        log.info("Fetching all Savings Accounts");
        return savingsRepository.findAll();
    }


    public void addInterest(Long id) {
        LocalDate dateNow = LocalDate.now();
        LocalDate creationDate = savingsRepository.findById(id).get().getCreationDate();
        int accountAge = dateNow.getYear() - creationDate.getYear();

        if (accountAge >= 1) {
            log.info("Interest Rate was added to your account");
            Money accountBalance = savingsRepository.findById(id).get().getBalance();
            BigDecimal accountInterest = savingsRepository.findById(id).get().getInterestRate();

            BigDecimal newBalance = (accountInterest.multiply(accountBalance.getAmount()));
            savingsRepository.findById(id).get().setBalance(new Money(newBalance));
        }
    }

    public Money findBalanceById(Long id) {
        if (savingsRepository.findById(id).isPresent()) {
            log.info("Fetching Account Balance");
            addInterest(id);
            return savingsRepository.findById(id).get().getBalance();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }

    public void modifyBalance(Long id, AccountBalanceDTO accountBalanceDTO) {
        Optional<Savings> account = savingsRepository.findById(id);
        if (account.isPresent()) {

            account.get().setBalance(accountBalanceDTO.getBalance());
            addInterest(id);
            savingsRepository.save(account.get());

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }


}
