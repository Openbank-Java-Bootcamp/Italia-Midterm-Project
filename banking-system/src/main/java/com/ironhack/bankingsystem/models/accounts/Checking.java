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
@Entity(name = "checking")
public class Checking extends Account{

    private String secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "minimum_balance_amount"))
    })
    private Money minimumBalance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "monthly_maintenance_fee"))
    })
    private Money monthlyMaintenanceFee;

    private Date creationDate;

    private Status status;


}
