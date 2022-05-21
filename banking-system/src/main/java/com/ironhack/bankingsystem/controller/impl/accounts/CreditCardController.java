package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.CreditCardDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ICreditCardController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.CreditCard;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICreditCardService;
import jakarta.validation.Valid;
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
    public void saveCreditCard(@RequestBody CreditCardDTO creditCardDTO) {
        creditCardService.saveCreditCard(creditCardDTO);
    }

    @GetMapping("/creditcards")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @GetMapping("/creditcards/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable Long id){

        return creditCardService.findBalanceById(id);
    }

    @PatchMapping("/creditcards/balance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyBalance(@PathVariable Long id, @RequestBody @Valid AccountBalanceDTO accountBalanceDTO) {
        creditCardService.modifyBalance(id, accountBalanceDTO );
    }
}
