package com.ironhack.bankingsystem.DTO.accountDTOs;
import com.ironhack.bankingsystem.models.Money;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class CheckingDTO{

    private Money balance;

    private Long primaryOwnerId;

    private Long secondaryOwnerId;

    private String secretKey;



    public CheckingDTO(Money balance, Long primaryOwnerId, Long secondaryOwnerId, String secretKey) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.secretKey = secretKey;
    }
}
