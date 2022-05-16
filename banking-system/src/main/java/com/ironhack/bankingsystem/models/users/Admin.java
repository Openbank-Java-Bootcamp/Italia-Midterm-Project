package com.ironhack.bankingsystem.models.users;

import jakarta.persistence.Entity;
import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "admin")
public class Admin extends User{
}
