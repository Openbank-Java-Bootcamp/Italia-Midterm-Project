package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ICheckingController;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/accounts")
public class CheckingController implements ICheckingController {

    @Autowired
    private ICheckingService checkingService;

    @PostMapping("/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveChecking(Checking checking) {
        checkingService.saveChecking(checking);
    }

    @GetMapping("/checkings")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getCheckings() {
        return checkingService.getCheckings();
    }
}
