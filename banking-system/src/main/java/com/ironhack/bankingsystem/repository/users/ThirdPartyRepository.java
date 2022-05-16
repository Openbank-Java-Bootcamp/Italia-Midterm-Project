package com.ironhack.bankingsystem.repository.users;

import com.ironhack.bankingsystem.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
}
