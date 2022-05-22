package com.ironhack.bankingsystem.models.accounts;


import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Money balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder PrimaryOwner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder SecondaryOwner;

    private final BigDecimal penaltyFee = BigDecimal.valueOf(40);

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.balance = balance;
        PrimaryOwner = primaryOwner;
        SecondaryOwner = secondaryOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return PrimaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        PrimaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return SecondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        SecondaryOwner = secondaryOwner;
    }

}
