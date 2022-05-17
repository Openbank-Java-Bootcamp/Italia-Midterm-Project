package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.RoleToUserDTO;
import com.ironhack.bankingsystem.models.Role;

public interface IRoleController {
    void saveRole(Role role);
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
