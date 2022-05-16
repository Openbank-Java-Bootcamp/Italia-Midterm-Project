package com.ironhack.bankingsystem.repository.accounts;

import com.ironhack.bankingsystem.models.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
