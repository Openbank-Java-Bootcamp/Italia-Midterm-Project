package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class StudentChecking extends Account{
    private String secretKey;
    private Date creationDate;
    private Status status;
}
