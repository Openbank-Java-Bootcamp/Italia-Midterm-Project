package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.IStudentCheckingController;
import com.ironhack.bankingsystem.service.impl.accounts.StudentCheckingService;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentCheckingController implements IStudentCheckingController {

    @Autowired
    private StudentCheckingService studentCheckingService;
}
