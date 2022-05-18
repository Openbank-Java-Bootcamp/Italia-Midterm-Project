package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.CreditCard;

import java.util.List;

public interface ICreditCardService {
    CreditCard saveCreditCard(CreditCard creditCard);
    List<CreditCard> getCreditCards();
}
