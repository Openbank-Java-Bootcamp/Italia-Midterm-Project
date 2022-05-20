package com.ironhack.bankingsystem.service.interfaces.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CreditCardDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.CreditCard;

import java.util.List;

public interface ICreditCardService {
    CreditCard saveCreditCard(CreditCardDTO creditCardDTO);
    List<CreditCard> getCreditCards();

    Money findBalanceById(Long id);

}
