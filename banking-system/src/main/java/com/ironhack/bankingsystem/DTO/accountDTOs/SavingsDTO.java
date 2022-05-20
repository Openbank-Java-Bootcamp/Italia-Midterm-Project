package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class SavingsDTO{

    private Money balance;

    private Long primaryOwnerId;

    private Long secondaryOwnerId;

    private String secretKey;

    private Money minimumBalance;

    @Column(precision = 32, scale = 4)
    private BigDecimal interestRate;;

    public SavingsDTO(Money balance, Long primaryOwnerId, Long secondaryOwnerId, String secretKey,
                      Money minimumBalance,  BigDecimal interestRate) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }


}
