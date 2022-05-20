package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.DTO.AccountToAccountHolderDTO;
import com.ironhack.bankingsystem.DTO.userDTOs.AccountHolderDTO;
import com.ironhack.bankingsystem.controller.interfaces.users.IAccountHolderController;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.service.interfaces.users.IAccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking/users")
public class AccountHolderController implements IAccountHolderController {

    @Autowired
    private IAccountHolderService accountHolderService;

    @PostMapping("/account-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccountHolder(AccountHolderDTO accountHolderDTO) {
        accountHolderService.saveAccountHolder(accountHolderDTO);
    }


    @GetMapping("/account-holder")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAccountHolders() {
        return accountHolderService.getAccountHolders();
    }

/*    @PostMapping("/account-holder/add-account")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAccountToHolder(@RequestBody AccountToAccountHolderDTO accountToAccountHolderDTO) {
        accountHolderService.add
    }*/
}
