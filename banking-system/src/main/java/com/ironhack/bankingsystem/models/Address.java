package com.ironhack.bankingsystem.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}
