package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "checking")
public class Checking extends Account{

    private String secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name="currency", column = @Column(name = "currency", updatable = false, insertable = false))
    })
    private Money minimumBalance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "monthly_maintenance_fee")),
            @AttributeOverride(name="currency", column = @Column(name = "currency", updatable = false, insertable = false))
    })
    private Money monthlyMaintenanceFee;

    private LocalDate creationDate;

    private Status status;

    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                    String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new  Money(BigDecimal.valueOf(250));
        this.monthlyMaintenanceFee =  new  Money(BigDecimal.valueOf(12));
        this.creationDate = LocalDate.now();
        this.status = Status.ACTIVE;
    }


}
