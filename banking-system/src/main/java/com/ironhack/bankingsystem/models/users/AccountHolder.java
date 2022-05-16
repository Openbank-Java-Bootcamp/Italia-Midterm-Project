package com.ironhack.bankingsystem.models.users;

import com.ironhack.bankingsystem.models.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "account_holder")
public class AccountHolder extends User{
    private Date dateOfBirth;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "primary_address_Street_Address")),
            @AttributeOverride(name = "city", column = @Column(name = "primary_address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "primary_address_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "primary_address_postalCode"))
    })
    private Address primaryAddress;
    @Embedded
    private Address mailingAddress;
}
