package com.ironhack.bankingsystem.repository.accounts;

import com.ironhack.bankingsystem.models.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
