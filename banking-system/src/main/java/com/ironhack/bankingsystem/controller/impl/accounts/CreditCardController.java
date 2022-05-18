package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.ICreditCardController;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/accounts")
public class CreditCardController implements ICreditCardController {

    @Autowired
    private ICreditCardService creditCardService;

    @PostMapping("/creditcards")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCreditCard(CreditCard creditCard) {
        creditCardService.saveCreditCard(creditCard);
    }

    @GetMapping("/creditcards")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }
}
