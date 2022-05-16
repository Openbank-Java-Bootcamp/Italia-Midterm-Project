package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.repository.accounts.CheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckingService implements ICheckingService {

    @Autowired
    private CheckingRepository checkingRepository;
}
