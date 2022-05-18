package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.enums.AccountType;
import com.ironhack.bankingsystem.models.accounts.Account;
import com.ironhack.bankingsystem.repository.accounts.AccountRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.IAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account saveAccount(Account account) {
        log.info("Saving new Account {} inside of the database", account.getId());
        return accountRepository.save(account);
    }


    public List<Account> getAccounts() {
        log.info("Fetching all Accounts");
        return accountRepository.findAll();
    }


//    public void addTypeToAccount(Long accountId, AccountType accountType) {
//    }
}
