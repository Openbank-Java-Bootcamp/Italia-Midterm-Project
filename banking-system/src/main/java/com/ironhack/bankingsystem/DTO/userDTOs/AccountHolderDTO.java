package com.ironhack.bankingsystem.DTO.userDTOs;

import com.ironhack.bankingsystem.DTO.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountHolderDTO extends UserDTO {
    private Date dateOfBirth;

    private AddressDTO primaryAddress;

    private AddressDTO mailingAddress;
}
