package com.ironhack.bankingsystem.models.accounts;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "credit_card")
public class CreditCard extends Account{
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
}
