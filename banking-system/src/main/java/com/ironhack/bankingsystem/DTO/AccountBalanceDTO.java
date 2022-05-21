package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.models.Money;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountBalanceDTO {

    //@NotEmpty(message = "Balance can't be empty or null.")
    private Money balance;


}
