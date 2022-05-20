package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "creditcard")
public class CreditCard extends Account{
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "credit_limit_amount")),
            @AttributeOverride(name="currency", column = @Column(name ="currency", updatable = false, insertable = false))
    })
    private Money creditLimit;

    private BigDecimal interestRate;

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                      Money creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public void setCreditLimit(Money creditLimit) {
        if(creditLimit.getAmount().compareTo(null)== 0){
            this.creditLimit =  new Money(BigDecimal.valueOf(100));
        }else if(creditLimit.getAmount().compareTo(BigDecimal.valueOf(100))==-1||
                creditLimit.getAmount().compareTo(BigDecimal.valueOf(100000))==1 ){
            throw new IllegalArgumentException("Credit Limit must be instantiated between 100 and 1000," +
                    " both inclusive");
        }else{
            this.creditLimit =  creditLimit;
        }
    }

    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.compareTo(null)== 0){
            this.interestRate =  BigDecimal.valueOf(0.2);
        }else if(interestRate.compareTo(BigDecimal.valueOf(0.1))==-1||
                interestRate.compareTo(BigDecimal.valueOf(0.2))==1 ){
            throw new IllegalArgumentException("Interest Rate must be instantiated between 0 and 0.5," +
                    " both inclusive");
        }else{
            this.interestRate = interestRate;
        }
    }
}
