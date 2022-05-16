package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
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
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "minimum_balance_amount"))
    })
    private Money minimumBalance;

    private Date creationDate;

    private Status status;

    private BigDecimal interestRate;
}
