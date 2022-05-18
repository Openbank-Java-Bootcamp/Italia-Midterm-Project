package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.repository.accounts.CheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICheckingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckingService implements ICheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    @Override
    public Checking saveChecking(Checking checking) {
        log.info("Saving new Checking Account {} inside of the database", checking.getId());
        //account.setPassword(passwordEncoder.encode(user.getPassword()));
        return checkingRepository.save(checking);
    }

    @Override
    public List<Checking> getCheckings() {
        log.info("Fetching all Checking Accounts");
        return checkingRepository.findAll();
    }
}
