package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.TransactionDTO;

public interface ITransactionController {

    void makeTransaction(TransactionDTO transactionDTO);
}
