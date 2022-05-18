package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.Account;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;

import java.util.List;

public interface IStudentCheckingService {
    StudentChecking saveStudentChecking(StudentChecking studentChecking);
    List<StudentChecking> getStudentCheckings();
}
