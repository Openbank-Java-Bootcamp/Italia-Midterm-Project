package com.ironhack.bankingsystem.repository;

import com.ironhack.bankingsystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
