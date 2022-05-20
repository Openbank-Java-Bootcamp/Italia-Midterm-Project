package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.Transaction;
import com.ironhack.bankingsystem.repository.TransactionRepository;
import com.ironhack.bankingsystem.service.interfaces.ITransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }
}
