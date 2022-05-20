package com.ironhack.bankingsystem.models.users;

import com.ironhack.bankingsystem.models.Address;
import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.models.accounts.Account;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "account_holder")
public class AccountHolder extends User{

    private LocalDate dateOfBirth;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "primary_address_Street_Address")),
            @AttributeOverride(name = "city", column = @Column(name = "primary_address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "primary_address_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "primary_address_postalCode"))
    })
    private Address primaryAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "mailing_address_Street_Address")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_address_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_address_postalCode"))
    })
    private Address mailingAddress;

    public AccountHolder(String name, String username, String password, Collection<Role> roles,
                         Collection<Account> accounts, LocalDate dateOfBirth, Address primaryAddress,
                         Address mailingAddress) {
        super(name, username, password, roles, accounts);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


}
