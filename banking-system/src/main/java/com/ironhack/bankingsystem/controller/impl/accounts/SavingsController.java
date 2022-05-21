package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.DTO.accountDTOs.SavingsDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ISavingsController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Savings;
import com.ironhack.bankingsystem.service.interfaces.accounts.ISavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/accounts")
public class SavingsController implements ISavingsController {

    @Autowired
    private ISavingsService savingsService;

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSavings(@RequestBody SavingsDTO savingsDTO) {
        savingsService.saveSavings(savingsDTO);
    }

    @GetMapping("/savings")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> getSavings() {
        return savingsService.getSavings();
    }

    @GetMapping("/savings/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable Long id){

        return savingsService.findBalanceById(id);
    }
}
