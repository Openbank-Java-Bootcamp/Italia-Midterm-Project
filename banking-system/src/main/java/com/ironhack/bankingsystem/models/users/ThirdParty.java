package com.ironhack.bankingsystem.models.users;

import jakarta.persistence.Entity;
import lombok.*;

import static com.ironhack.bankingsystem.secureUtils.HashKey.getSHA512;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "third_party")
public class ThirdParty extends User{
    private String hashedKey; //in constructor = getSHA512(getHashedKey());

}
