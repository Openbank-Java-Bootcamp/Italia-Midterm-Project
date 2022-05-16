package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "savings")
public class Savings extends Account{
    private String secretKey;
    private BigDecimal minimumBalance;
    private Date creationDate;
    private Status status;
    private BigDecimal interestRate;
}
