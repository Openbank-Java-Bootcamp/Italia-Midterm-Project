package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.models.Money;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "credit_card")
public class CreditCard extends Account{
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "credit_limit_amount")),
            @AttributeOverride(name="currency", column = @Column(name ="currency", updatable = false, insertable = false))
    })
    private Money creditLimit;

    private BigDecimal interestRate;
}
