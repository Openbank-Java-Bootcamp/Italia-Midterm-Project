package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.controller.interfaces.users.IAdminController;
import com.ironhack.bankingsystem.service.impl.users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class AdminController implements IAdminController {

    @Autowired
    private AdminService adminService;
}
