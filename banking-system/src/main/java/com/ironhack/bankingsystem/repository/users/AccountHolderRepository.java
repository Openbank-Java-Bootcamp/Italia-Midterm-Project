package com.ironhack.bankingsystem.repository.users;

import com.ironhack.bankingsystem.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
