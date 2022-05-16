package com.ironhack.bankingsystem.models.users;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
//@Table(name = "third_party")
public class ThirdParty extends User{
    private String hashedKey; //TODO
}
