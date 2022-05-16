package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.controller.interfaces.users.IAccountHolderController;
import com.ironhack.bankingsystem.service.impl.users.AccountHolderService;
import com.ironhack.bankingsystem.service.interfaces.users.IAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class AccountController implements IAccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;
}
