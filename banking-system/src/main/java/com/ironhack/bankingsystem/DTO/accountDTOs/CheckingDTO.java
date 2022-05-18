package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.DTO.MoneyDTO;
import com.ironhack.bankingsystem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckingDTO extends AccountDTO {

    private String secretKey;

    private MoneyDTO minimumBalance;

    private MoneyDTO monthlyMaintenanceFee;

    private Date creationDate;

    private Status status;

}
