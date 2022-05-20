package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.Transaction;

public interface ITransactionService {
    Transaction saveTransaction(Transaction transaction);
}
