package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.models.users.User;
import com.ironhack.bankingsystem.repository.RoleRepository;
import com.ironhack.bankingsystem.repository.users.UserRepository;
import com.ironhack.bankingsystem.service.interfaces.IRoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public Role saveRole(Role role) {
        log.info("Saving a new role {} to database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
