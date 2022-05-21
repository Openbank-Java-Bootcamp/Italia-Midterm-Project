package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.CreditCardDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.repository.accounts.CreditCardRepository;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;


    public CreditCard saveCreditCard(CreditCardDTO creditCardDTO) {

        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(creditCardDTO.getPrimaryOwnerId());
        if(accountHolder.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account holder found with that ID");
        }
        if (accountHolder.isPresent()) {
           log.info("Saving new CreditCard Account inside of the database");
            return creditCardRepository.save(new CreditCard(creditCardDTO.getBalance(),
                    accountHolderRepository.findById(creditCardDTO.getPrimaryOwnerId()).get(),
                    accountHolderRepository.findById(creditCardDTO.getSecondaryOwnerId()).get(),
                    creditCardDTO.getCreditLimit(), creditCardDTO.getInterestRate()));

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id wasn't found.");
        }
    }

    public List<CreditCard> getCreditCards() {
        log.info("Fetching all CreditCard Accounts");
        return creditCardRepository.findAll();
    }

    public Money findBalanceById(Long id) {
        if (creditCardRepository.findById(id).isPresent()) {
            log.info("Fetching Account Balance");
            return creditCardRepository.findById(id).get().getBalance();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }

    public void modifyBalance(Long id, AccountBalanceDTO accountBalanceDTO) {
        Optional<CreditCard> account = creditCardRepository.findById(id);
        if (account.isPresent()) {

            account.get().setBalance(accountBalanceDTO.getBalance());
            creditCardRepository.save(account.get());

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id wasn't found.");
        }
    }
}
