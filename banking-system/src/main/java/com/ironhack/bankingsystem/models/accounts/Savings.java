package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    private LocalDate creationDate;

    private Status status;

    @DecimalMax(value = "0.5", inclusive = true, message = "Interest Rate mustn't pass 0.5")
    @DecimalMin(value = "0", inclusive = true, message = "Interest Rate mustn't be negative")
    @Column(precision = 32, scale = 4)
    private BigDecimal interestRate; //TODO Consider using @Digits() instead

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   String secretKey, Money minimumBalance, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.creationDate = LocalDate.now();
        this.status = Status.ACTIVE;
        setInterestRate(interestRate);
    }

    public void setMinimumBalance(Money minimumBalance) {
        if(minimumBalance.getAmount().compareTo(null)== 0){
            this.minimumBalance =  new Money(BigDecimal.valueOf(1000));
        }else if(minimumBalance.getAmount().compareTo(BigDecimal.valueOf(100))==-1||
                minimumBalance.getAmount().compareTo(BigDecimal.valueOf(1000))==1 ){
            throw new IllegalArgumentException("Minimum Balance must be instantiated between 100 and 1000," +
                    " both inclusive");
        }else{
            this.minimumBalance =  minimumBalance;
        }
    }

    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.compareTo(null)== 0){
            this.interestRate =  BigDecimal.valueOf(0.0025);
        }else if(interestRate.compareTo(BigDecimal.valueOf(0))==-1||
                interestRate.compareTo(BigDecimal.valueOf(0.5))==1 ){
            throw new IllegalArgumentException("Interest Rate must be instantiated between 0 and 0.5," +
                    " both inclusive");
        }else{
            this.interestRate = interestRate;
        }

    }
}
