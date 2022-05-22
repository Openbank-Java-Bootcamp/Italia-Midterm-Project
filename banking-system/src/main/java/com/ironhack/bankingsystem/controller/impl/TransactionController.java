package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.DTO.TransactionDTO;
import com.ironhack.bankingsystem.controller.interfaces.ITransactionController;
import com.ironhack.bankingsystem.service.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banking")
public class TransactionController implements ITransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionService.makeTransaction(transactionDTO);
    }
}
