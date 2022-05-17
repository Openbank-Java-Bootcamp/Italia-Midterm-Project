package com.ironhack.bankingsystem.repository.accounts;

import com.ironhack.bankingsystem.models.accounts.Account;
import com.ironhack.bankingsystem.models.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
