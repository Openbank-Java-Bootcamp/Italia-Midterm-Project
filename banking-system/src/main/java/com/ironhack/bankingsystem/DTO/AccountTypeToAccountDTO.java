package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.enums.AccountType;
import lombok.Data;

@Data
public class AccountTypeToAccountDTO {
    private Long accountId;
    private AccountType accountType;
}
