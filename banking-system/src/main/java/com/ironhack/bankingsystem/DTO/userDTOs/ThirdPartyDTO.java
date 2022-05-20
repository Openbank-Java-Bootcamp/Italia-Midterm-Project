package com.ironhack.bankingsystem.DTO.userDTOs;

import com.ironhack.bankingsystem.models.Role;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThirdPartyDTO {

    private String name;
    //private String username;
    //private Collection<Role> roles = new ArrayList<>();
    private String hashedKey; //in service = getSHA512(getHashedKey());

}
