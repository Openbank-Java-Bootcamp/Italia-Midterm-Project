package com.ironhack.bankingsystem.models.users;

import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.models.accounts.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.*;

import java.util.Collection;

import static com.ironhack.bankingsystem.secureUtils.HashKey.getSHA512;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "third_party")
public class ThirdParty{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hashedKey;

    public ThirdParty(String name, String hashedKey) {
        this.name = name;
        getSHA512(hashedKey);
    }
}
