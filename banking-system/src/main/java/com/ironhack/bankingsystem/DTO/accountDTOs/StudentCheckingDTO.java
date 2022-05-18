package com.ironhack.bankingsystem.DTO.accountDTOs;

import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCheckingDTO extends AccountDTO {
    private String secretKey;
    private Date creationDate;
    private Status status;
}
