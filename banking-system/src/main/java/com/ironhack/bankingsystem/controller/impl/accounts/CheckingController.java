package com.ironhack.bankingsystem.controller.impl.accounts;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.CheckingDTO;
import com.ironhack.bankingsystem.DTO.accountDTOs.StudentCheckingDTO;
import com.ironhack.bankingsystem.controller.interfaces.accounts.ICheckingController;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.models.users.AccountHolder;
import com.ironhack.bankingsystem.repository.users.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.accounts.ICheckingService;
import com.ironhack.bankingsystem.service.interfaces.accounts.IStudentCheckingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banking/accounts")
public class CheckingController implements ICheckingController {

    @Autowired
    private ICheckingService checkingService;

    @Autowired
    private IStudentCheckingService studentCheckingService;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @PostMapping("/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveChecking(@RequestBody CheckingDTO checkingDTO) {

        System.out.println(checkingDTO.toString());
        LocalDate dateNow = LocalDate.now();
        Optional<AccountHolder> foundAccountHolder = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId());
        if(foundAccountHolder.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account holder with that ID");
        }
        var birthDate = foundAccountHolder.get().getDateOfBirth();
        var age = dateNow.getYear() - birthDate.getYear();
        if (age < 24) {
            StudentCheckingDTO studentCheckingDTO = new StudentCheckingDTO(checkingDTO.getBalance(),
                    checkingDTO.getPrimaryOwnerId(), checkingDTO.getSecondaryOwnerId(),
                    checkingDTO.getSecretKey());
            studentCheckingService.saveStudentChecking(studentCheckingDTO);
        } else if (age > 24) {
            checkingService.saveChecking(checkingDTO);
        }

    }

    @GetMapping("/checkings")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getCheckings() {
        return checkingService.getCheckings();
    }

    @GetMapping("/checkings/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable Long id){

        return checkingService.findBalanceById(id);
    }

    @PatchMapping("/checkings/balance/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyBalance(@PathVariable Long id, @RequestBody @Valid AccountBalanceDTO accountBalanceDTO) {
        checkingService.modifyBalance(id, accountBalanceDTO );
    }

}
