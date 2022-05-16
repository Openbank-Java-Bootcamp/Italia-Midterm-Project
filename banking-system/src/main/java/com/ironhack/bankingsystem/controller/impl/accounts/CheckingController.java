package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ICheckingController;
import com.ironhack.bankingsystem.service.impl.accounts.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class CheckingController implements ICheckingController {

    @Autowired
    private CheckingService checkingService;
}
