package com.ironhack.bankingsystem.repository.users;

import com.ironhack.bankingsystem.models.users.ThirdParty;
import com.ironhack.bankingsystem.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);

}
