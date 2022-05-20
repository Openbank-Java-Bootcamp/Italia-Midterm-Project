package com.ironhack.bankingsystem.service.impl.users;

import com.ironhack.bankingsystem.DTO.userDTOs.AccountHolderDTO;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.repository.accounts.AccountRepository;
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
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountHolder saveAccountHolder(AccountHolderDTO aHDTO) {
        AccountHolder accountHolder = new AccountHolder(aHDTO.getName(),aHDTO.getUsername(),  aHDTO.getPassword(), aHDTO.getRoles(), aHDTO.getAccounts(),
                aHDTO.getDateOfBirth(), aHDTO.getPrimaryAddress(),
                aHDTO.getMailingAddress());
        log.info("Saving Account Holder {} in database", accountHolder.getName());
        accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> getAccountHolders() {
        log.info("Fetching all Account Holders");
        return accountHolderRepository.findAll();
    }

/*    public void addAccountToHolder(Long accountId, Long accountHolderId) {

        AccountHolder holder = accountHolderRepository.findById(accountHolderId).get();
        holder.getAccounts().add(accountId.)

    }*/
}
