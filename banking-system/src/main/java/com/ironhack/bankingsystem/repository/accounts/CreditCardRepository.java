package com.ironhack.bankingsystem.repository.accounts;

import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Money findBalanceById(Long id);}
