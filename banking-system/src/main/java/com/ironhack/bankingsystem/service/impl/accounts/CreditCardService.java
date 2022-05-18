package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.models.accounts.CreditCard;
import com.ironhack.bankingsystem.repository.accounts.CreditCardRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard saveCreditCard(CreditCard creditCard) {
        log.info("Saving new CreditCard Account {} inside of the database", creditCard.getId());
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> getCreditCards() {
        log.info("Fetching all CreditCard Accounts");
        return creditCardRepository.findAll();
    }
}
