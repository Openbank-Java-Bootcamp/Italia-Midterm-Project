package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CheckingDTO;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;
import com.ironhack.bankingsystem.repository.accounts.CheckingRepository;
import com.ironhack.bankingsystem.repository.accounts.StudentCheckingRepository;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckingService implements ICheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public Checking saveChecking(CheckingDTO checkingDTO) {

        var accountHolder = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId());
        if (accountHolder.isPresent()) {
            log.info("Saving new Checking Account inside of the database");
            return checkingRepository.save(new Checking(
                    checkingDTO.getBalance(), accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId()).get(),
                    accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).get(),
                    checkingDTO.getSecretKey()));

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id doesn't exist.");
        }
    }

    public List<Checking> getCheckings() {
        log.info("Fetching all Checking Accounts");
        return checkingRepository.findAll();
    }

    public Money findBalanceById(Long id) {

        if (checkingRepository.findById(id).isPresent()) {

            log.info("Fetching Account Balance");
            return checkingRepository.findById(id).get().getBalance();

        /*}else if(studentCheckingRepository.findById(id).isPresent()){
            log.info("Fetching Account Balance");
            return studentCheckingRepository.findById(id).get().getBalance();*/
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }
}
