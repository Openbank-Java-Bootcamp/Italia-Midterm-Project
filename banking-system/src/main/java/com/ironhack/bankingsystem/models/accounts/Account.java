package com.ironhack.bankingsystem.models.accounts;


import com.ironhack.bankingsystem.models.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="account_type",
        //discriminatorType = DiscriminatorType.)
//@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private User PrimaryOwner;
    private User SecondaryOwner;
    private final Integer penaltyFee = 40;

}
