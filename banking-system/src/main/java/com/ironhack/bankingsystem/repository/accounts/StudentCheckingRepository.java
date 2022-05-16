package com.ironhack.bankingsystem.repository.accounts;

import com.ironhack.bankingsystem.models.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
