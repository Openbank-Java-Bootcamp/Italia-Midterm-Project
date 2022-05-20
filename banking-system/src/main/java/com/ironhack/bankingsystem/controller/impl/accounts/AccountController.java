package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.controller.interfaces.accounts.IAccountController;
import com.ironhack.bankingsystem.models.accounts.Account;
import com.ironhack.bankingsystem.service.interfaces.accounts.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking")
public class AccountController implements IAccountController {

    @Autowired
    private IAccountService accountService;

    /*@PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }*/

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }


}
