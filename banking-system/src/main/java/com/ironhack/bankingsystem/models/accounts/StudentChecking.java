package com.ironhack.bankingsystem.models.accounts;

import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "student_checking")
public class StudentChecking extends Account{
    private String secretKey;
    private LocalDate creationDate;
    private Status status;

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                           String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.creationDate = LocalDate.now();
        this.status = Status.ACTIVE;
    }
}
