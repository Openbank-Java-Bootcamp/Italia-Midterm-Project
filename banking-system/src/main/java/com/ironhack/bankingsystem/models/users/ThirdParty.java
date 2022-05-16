package com.ironhack.bankingsystem.models.users;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "third_party")
public class ThirdParty extends User{
    private String hashedKey; //TODO
}
