package com.ironhack.bankingsystem.DTO;

import lombok.Data;

@Data
public class AccountToAccountHolderDTO {
    private Long accountId;
    private Long accountHolderId;
}
