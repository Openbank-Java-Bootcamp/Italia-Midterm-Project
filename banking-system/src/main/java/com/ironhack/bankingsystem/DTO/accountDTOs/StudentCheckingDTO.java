package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class StudentCheckingDTO {
    private Money balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private String secretKey;

    public StudentCheckingDTO(Money balance, Long primaryOwnerId, Long secondaryOwnerId, String secretKey) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.secretKey = secretKey;
    }

}
