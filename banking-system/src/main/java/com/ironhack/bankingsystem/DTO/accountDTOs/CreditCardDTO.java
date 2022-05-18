package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.DTO.MoneyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDTO extends AccountDTO {

    private MoneyDTO creditLimit;

    private BigDecimal interestRate;
}
