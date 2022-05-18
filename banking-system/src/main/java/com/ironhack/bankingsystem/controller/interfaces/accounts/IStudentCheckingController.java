package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.StudentChecking;

import java.util.List;

public interface IStudentCheckingController {
    void saveStudentChecking(StudentChecking studentChecking);
    List<StudentChecking> getStudentCheckings();
}
