package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.Role;

public interface IRoleService {
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
}
