package com.ironhack.bankingsystem.models.accounts;


import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="account_type",
        //discriminatorType = DiscriminatorType.)
//@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Money balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_owner_id")
    private User PrimaryOwner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_owner_id")
    private User SecondaryOwner;

    private final Integer penaltyFee = 40;

}
