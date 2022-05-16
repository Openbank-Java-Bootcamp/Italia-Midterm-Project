package com.ironhack.bankingsystem.service.impl.users;

import com.ironhack.bankingsystem.repository.users.AdminRepository;
import com.ironhack.bankingsystem.service.interfaces.users.IAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;
}
