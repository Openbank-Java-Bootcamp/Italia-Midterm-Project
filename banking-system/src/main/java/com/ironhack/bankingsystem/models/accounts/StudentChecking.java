package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "student_checking")
public class StudentChecking extends Account{
    private String secretKey;
    private Date creationDate;
    private Status status;
}
