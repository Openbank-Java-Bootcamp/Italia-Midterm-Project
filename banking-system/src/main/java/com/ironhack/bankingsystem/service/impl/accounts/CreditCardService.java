package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.CreditCardDTO;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;


    public CreditCard saveCreditCard(CreditCardDTO creditCardDTO) {

        var accountHolder = accountHolderRepository.findById(creditCardDTO.getPrimaryOwnerId());
        if (accountHolder.isPresent()) {


            CreditCard creditCard = new CreditCard(creditCardDTO.getBalance(),
                    accountHolderRepository.findById(creditCardDTO.getPrimaryOwnerId()).get(),
                    accountHolderRepository.findById(creditCardDTO.getSecondaryOwnerId()).get(),
                    creditCardDTO.getCreditLimit(), creditCardDTO.getInterestRate());
            log.info("Saving new CreditCard Account {} inside of the database", creditCard.getId());
            return creditCardRepository.save(creditCard);

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Holder Id doesn't exist.");
        }
    }

    public List<CreditCard> getCreditCards() {
        log.info("Fetching all CreditCard Accounts");
        return creditCardRepository.findAll();
    }

    public Money findBalanceById(Long id) {

        var account = creditCardRepository.findById(id);
        if (account.isPresent()) {
            log.info("Fetching Account Balance");
            return creditCardRepository.findById(id).get().getBalance();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account Id doesn't exist.");
        }
    }
}
