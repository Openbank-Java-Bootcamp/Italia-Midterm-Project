package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.models.accounts.StudentChecking;
import com.ironhack.bankingsystem.repository.accounts.StudentCheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentCheckingService implements IStudentCheckingService {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    public StudentChecking saveStudentChecking(StudentChecking studentChecking) {
        log.info("Saving new Student Checking Account {} inside of the database", studentChecking.getId());
        return studentCheckingRepository.save(studentChecking);
    }

    public List<StudentChecking> getStudentCheckings() {
        log.info("Fetching all Student Checking Accounts");
        return studentCheckingRepository.findAll();
    }
}
