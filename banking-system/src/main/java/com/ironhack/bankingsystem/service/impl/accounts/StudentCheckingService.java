package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.repository.accounts.StudentCheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentCheckingService implements IStudentCheckingService {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
}
