package com.ironhack.bankingsystem.controller.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CreditCardDTO;
import com.ironhack.bankingsystem.models.accounts.CreditCard;

import java.util.List;

public interface ICreditCardController {

    void saveCreditCard(CreditCardDTO creditCardDTO);
    List<CreditCard> getCreditCards();
}
