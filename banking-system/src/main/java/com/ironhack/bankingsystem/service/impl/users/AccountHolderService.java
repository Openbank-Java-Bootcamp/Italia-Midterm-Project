package com.ironhack.bankingsystem.service.impl.users;

import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.users.IAccountHolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountHolderService implements IAccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
        log.info("Saving Account Holder {} in database", accountHolder.getName());
        accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> getAccountHolders() {
        log.info("Fetching all Account Holders");
        return accountHolderRepository.findAll();
    }
}
