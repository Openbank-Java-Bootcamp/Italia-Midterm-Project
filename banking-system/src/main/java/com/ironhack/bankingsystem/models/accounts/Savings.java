package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
            @AttributeOverride(name="amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name="currency", column = @Column(name = "currency", updatable = false, insertable = false))
    })
    private Money minimumBalance;

    private Date creationDate;

    private Status status;
  /*  @DecimalMax(value = "0.5", message = "Interest") //Setter o Service
    @DecimalMin(value = "0", message = "")*/
    @Column(precision = 32, scale = 4)
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);

/*    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.0025") : interestRate;
    }*/
}
