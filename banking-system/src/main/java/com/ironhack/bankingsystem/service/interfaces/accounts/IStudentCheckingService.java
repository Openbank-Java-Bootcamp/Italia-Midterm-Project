package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;

import java.util.List;

public interface IStudentCheckingService {
    StudentChecking saveStudentChecking(StudentCheckingDTO studentCheckingDTO);
    List<StudentChecking> getStudentCheckings();

    Money findBalanceById(Long id);

    void modifyBalance(Long id, AccountBalanceDTO accountBalanceDTO);

}
