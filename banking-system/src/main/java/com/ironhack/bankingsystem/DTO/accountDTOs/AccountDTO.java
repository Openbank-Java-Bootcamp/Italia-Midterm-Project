package com.ironhack.bankingsystem.DTO.accountDTOs;


import com.ironhack.bankingsystem.models.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO {

    private Money balance;

    private Long primaryOwnerId;

    private Long secondaryOwnerId;

    private Integer penaltyFee;

}
