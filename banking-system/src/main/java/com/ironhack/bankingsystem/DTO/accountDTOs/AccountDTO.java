package com.ironhack.bankingsystem.DTO.accountDTOs;


import com.ironhack.bankingsystem.DTO.MoneyDTO;
import com.ironhack.bankingsystem.DTO.userDTOs.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


//@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO {

    private MoneyDTO balance;

    private UserDTO PrimaryOwner;

    private UserDTO SecondaryOwner;

    private final Integer penaltyFee = 40;

    public AccountDTO(MoneyDTO balance, UserDTO primaryOwner, UserDTO secondaryOwner) {
        this.balance = balance;
        PrimaryOwner = primaryOwner;
        SecondaryOwner = secondaryOwner;
    }
}
