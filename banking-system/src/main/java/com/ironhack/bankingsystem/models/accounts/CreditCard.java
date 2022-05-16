package com.ironhack.bankingsystem.models.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CreditCard extends Account{
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
}
