package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;

import java.util.List;

public interface IStudentCheckingController {
//    void saveStudentChecking(StudentCheckingDTO studentCheckingDTO);
    List<StudentChecking> getStudentCheckings();
}
