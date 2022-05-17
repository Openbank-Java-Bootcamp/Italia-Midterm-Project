package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.repository.accounts.AccountRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.IAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
}
