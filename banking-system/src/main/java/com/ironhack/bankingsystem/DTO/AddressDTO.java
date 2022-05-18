package com.ironhack.bankingsystem.DTO;

import jakarta.persistence.Embeddable;

//@Embeddable
public class AddressDTO {
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}
