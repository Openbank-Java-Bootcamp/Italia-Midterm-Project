package com.ironhack.bankingsystem.service.interfaces.users;

import com.ironhack.bankingsystem.DTO.userDTOs.UserDTO;
import com.ironhack.bankingsystem.models.users.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
//    User saveUser(UserDTO userDTO);
    List<User> getUsers();
    UserDetails loadUserByUsername (String username);
}
