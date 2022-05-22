package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.TransactionDTO;
import com.ironhack.bankingsystem.models.Transaction;

public interface ITransactionService {
    Transaction saveTransaction(Transaction transaction);

    Transaction makeTransaction(TransactionDTO transactionDTO);

    void implementTransaction(TransactionDTO transactionDTO);

    void validateTransaction(TransactionDTO transactionDTO);

    void applyPenaltyFee(TransactionDTO transactionDTO);
}
