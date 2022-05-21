package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.models.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CreditCardDTO{

    private Money balance;

    private Long primaryOwnerId;

    private Long secondaryOwnerId;

    private Money creditLimit;

    private BigDecimal interestRate;

    public CreditCardDTO(Money balance, Long primaryOwnerId, Long secondaryOwnerId) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
    }



}
