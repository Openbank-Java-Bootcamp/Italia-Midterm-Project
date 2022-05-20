package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.IStudentCheckingController;
import com.ironhack.bankingsystem.models.accounts.StudentChecking;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/accounts")
public class StudentCheckingController implements IStudentCheckingController {

    @Autowired
    private IStudentCheckingService studentCheckingService;

/*    @PostMapping("/student-checking")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudentChecking(StudentCheckingDTO studentCheckingDTO) {
        studentCheckingService.saveStudentChecking(studentCheckingDTO);
    }*/

    @GetMapping("/student-checking")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> getStudentCheckings() {
        return studentCheckingService.getStudentCheckings();
    }
}
