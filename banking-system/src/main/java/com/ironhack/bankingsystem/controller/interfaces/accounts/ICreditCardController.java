package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.models.accounts.CreditCard;

import java.util.List;

public interface ICreditCardController {

    void saveCreditCard(CreditCard creditCard);
    List<CreditCard> getCreditCards();
}
