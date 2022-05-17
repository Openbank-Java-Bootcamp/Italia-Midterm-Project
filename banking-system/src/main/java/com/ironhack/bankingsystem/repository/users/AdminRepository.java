package com.ironhack.bankingsystem.repository.users;

import com.ironhack.bankingsystem.models.users.Admin;
import com.ironhack.bankingsystem.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
