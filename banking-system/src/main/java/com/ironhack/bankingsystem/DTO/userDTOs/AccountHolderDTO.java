package com.ironhack.bankingsystem.DTO.userDTOs;

import com.ironhack.bankingsystem.models.Address;
import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.models.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountHolderDTO {

    private String name;

    private String username;

    private String password;

    private Collection<Role> roles = new ArrayList<>();

    private Collection<Account> accounts = new ArrayList<>();

    private LocalDate dateOfBirth;

    private Address primaryAddress;

    private Address mailingAddress;

/*    public void setPassword(String password) {
        this.password = password;
    }*/
}
