package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ICheckingController;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ICreditCardController;
import com.ironhack.bankingsystem.service.impl.accounts.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class CreditCardController implements ICreditCardController {

    @Autowired
    private CreditCardService creditCardService;
}
