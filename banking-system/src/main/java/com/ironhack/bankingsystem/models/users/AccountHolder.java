package com.ironhack.bankingsystem.models.users;

import com.ironhack.bankingsystem.models.Address;
import jakarta.persistence.Entity;
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
//@Table(name = "account_holder")
public class AccountHolder extends User{
    private Date dateOfBirth;
    private Address primaryAddress; //embeded
    private Address mailingAddress; //embeded optional
}
