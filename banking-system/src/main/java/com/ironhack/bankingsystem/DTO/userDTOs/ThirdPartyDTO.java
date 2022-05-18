package com.ironhack.bankingsystem.DTO.userDTOs;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThirdPartyDTO extends UserDTO {
    private String hashedKey; //in constructor = getSHA512(getHashedKey());

}
