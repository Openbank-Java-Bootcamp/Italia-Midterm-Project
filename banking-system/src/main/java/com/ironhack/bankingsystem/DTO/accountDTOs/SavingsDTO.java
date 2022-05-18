package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.DTO.MoneyDTO;
import com.ironhack.bankingsystem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavingsDTO extends AccountDTO {

    private String secretKey;

    private MoneyDTO minimumBalance;

    private Date creationDate;

    private Status status;

    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);

/*    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.0025") : interestRate;
    }*/
}
