package com.ironhack.bankingsystem.service.impl.accounts;

import com.ironhack.bankingsystem.repository.accounts.CreditCardRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;
}
