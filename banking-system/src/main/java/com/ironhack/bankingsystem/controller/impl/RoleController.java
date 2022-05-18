package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.DTO.RoleToUserDTO;
import com.ironhack.bankingsystem.controller.interfaces.IRoleController;
import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banking")
public class RoleController implements IRoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @PostMapping("/roles/adduser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        roleService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getUsername());
    }
}
