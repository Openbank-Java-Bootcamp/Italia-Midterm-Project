package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Savings;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;
import com.ironhack.bankingsystem.repository.accounts.StudentCheckingRepository;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentCheckingService implements IStudentCheckingService {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;


    public StudentChecking saveStudentChecking(StudentCheckingDTO studentCheckingDTO) {

        var accountHolder = accountHolderRepository.findById(studentCheckingDTO.getPrimaryOwnerId());
        if (accountHolder.isPresent()) {

            StudentChecking studentChecking = new StudentChecking(studentCheckingDTO.getBalance(),
                    accountHolderRepository.findById(studentCheckingDTO.getPrimaryOwnerId()).get(),
                    accountHolderRepository.findById(studentCheckingDTO.getSecondaryOwnerId()).get(),
                     studentCheckingDTO.getSecretKey());
            log.info("Saving new Student Checking Account {} inside of the database", studentChecking.getId());
            return studentCheckingRepository.save(studentChecking);

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id wasn't found.");
        }
    }

    public List<StudentChecking> getStudentCheckings() {
        log.info("Fetching all Student Checking Accounts");
        return studentCheckingRepository.findAll();
    }

    public Money findBalanceById(Long id) {
        if (studentCheckingRepository.findById(id).isPresent()) {

            log.info("Fetching Account Balance");
            return studentCheckingRepository.findById(id).get().getBalance();

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }

    public void modifyBalance(Long id, AccountBalanceDTO accountBalanceDTO) {
        Optional<StudentChecking> account = studentCheckingRepository.findById(id);
        if (account.isPresent()) {

            account.get().setBalance(accountBalanceDTO.getBalance());
            studentCheckingRepository.save(account.get());

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }
}
