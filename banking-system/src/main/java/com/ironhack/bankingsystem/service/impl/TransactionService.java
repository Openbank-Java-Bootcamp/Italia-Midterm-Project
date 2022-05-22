package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.TransactionDTO;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.Money;
import com.ironhack.bankingsystem.models.Transaction;
import com.ironhack.bankingsystem.models.accounts.Account;
import com.ironhack.bankingsystem.models.accounts.Checking;
import com.ironhack.bankingsystem.models.accounts.Savings;
import com.ironhack.bankingsystem.repository.TransactionRepository;
import com.ironhack.bankingsystem.repository.accounts.AccountRepository;
import com.ironhack.bankingsystem.repository.accounts.CheckingRepository;
import com.ironhack.bankingsystem.repository.accounts.SavingsRepository;
import com.ironhack.bankingsystem.service.interfaces.ITransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    public Transaction saveTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }




    public void validateTransaction(TransactionDTO transactionDTO) {

        Optional<Account> requesterAccount = accountRepository.findById(transactionDTO.getRequesterAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transactionDTO.getTargetAccountId());

        BigDecimal requesterBalance = requesterAccount.get().getBalance().getAmount();
        BigDecimal requestedAmount = transactionDTO.getAmount().getAmount();
        BigDecimal targetBalance = requesterAccount.get().getBalance().getAmount();

        if(requesterBalance.compareTo(requestedAmount)==1 || requesterBalance.compareTo(requestedAmount)==0){

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your transaction is invalid,  insufficient founds");

        }

        if(targetBalance.compareTo(requestedAmount)==1 || requesterBalance.compareTo(requestedAmount)==0){

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your transaction is invalid,  insufficient founds");

        }

    }

    public void implementTransaction(TransactionDTO transactionDTO) {

        Optional<Account> requesterAccount = accountRepository.findById(transactionDTO.getRequesterAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transactionDTO.getTargetAccountId());

        if(requesterAccount.isPresent() && targetAccount.isPresent()){

            log.info("Your transaction has been accepted");

            BigDecimal requesterBalance = requesterAccount.get().getBalance().getAmount();
            BigDecimal targetBalance = targetAccount.get().getBalance().getAmount();

            requesterAccount.get().setBalance(new Money(requesterBalance.subtract(transactionDTO.getAmount().getAmount()),
                    transactionDTO.getAmount().getCurrency()));
            targetAccount.get().setBalance(new Money(targetBalance.add(transactionDTO.getAmount().getAmount()),
                    transactionDTO.getAmount().getCurrency()));

            accountRepository.save(requesterAccount.get());
            accountRepository.save(targetAccount.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your transaction wasn't implemented, please try again");
        }
    }

    public void applyPenaltyFee(TransactionDTO transactionDTO) {

        Optional<Account> requesterAccount = accountRepository.findById(transactionDTO.getRequesterAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transactionDTO.getTargetAccountId());

        BigDecimal requesterBalance = requesterAccount.get().getBalance().getAmount();
        BigDecimal requestedAmount = transactionDTO.getAmount().getAmount();


        if(requesterAccount.get().getClass().equals(Checking.class)){
            Optional<Checking> checkingAccount = checkingRepository.findById(transactionDTO.getRequesterAccountId());
            BigDecimal requesterMinBalance = checkingAccount.get().getMinimumBalance() .getAmount();

            if(requesterBalance.compareTo(requesterMinBalance)==-1){
                log.info("You have passed the minimum balance, penalty fee was applied.");
                requesterBalance.subtract(requesterAccount.get().getPenaltyFee());
                accountRepository.save(requesterAccount.get());
            }

        }else if(requesterAccount.get().getClass().equals(Savings.class)){
            Optional<Savings> savingsAccount = savingsRepository.findById(transactionDTO.getRequesterAccountId());
            BigDecimal requesterMinBalance = savingsAccount.get().getMinimumBalance() .getAmount();

            if(requesterBalance.compareTo(requesterMinBalance)==-1){
                log.info("You have passed the minimum balance, penalty fee was applied.");
                requesterBalance.subtract(requesterAccount.get().getPenaltyFee());
                accountRepository.save(requesterAccount.get());
            }
        }

        if(targetAccount.get().getClass().equals(Checking.class)){
            Optional<Checking> checkingAccount = checkingRepository.findById(transactionDTO.getRequesterAccountId());
            BigDecimal requesterMinBalance = checkingAccount.get().getMinimumBalance() .getAmount();

            if(requesterBalance.compareTo(requesterMinBalance)==-1){
                log.info("You have passed the minimum balance, penalty fee was applied.");
                requesterBalance.subtract(targetAccount.get().getPenaltyFee());
                accountRepository.save(targetAccount.get());
            }

        }else if(targetAccount.get().getClass().equals(Savings.class)){
            Optional<Savings> savingsAccount = savingsRepository.findById(transactionDTO.getRequesterAccountId());
            BigDecimal requesterMinBalance = savingsAccount.get().getMinimumBalance().getAmount();

            if(requesterBalance.compareTo(requesterMinBalance)==-1){
                log.info("You have passed the minimum balance, penalty fee was applied.");
                requesterBalance.subtract(targetAccount.get().getPenaltyFee());
                accountRepository.save(targetAccount.get());
            }
        }
    }

    public Transaction makeTransaction(TransactionDTO transactionDTO) {

        Optional<Account> requesterAccount = accountRepository.findById(transactionDTO.getRequesterAccountId());
        Optional<Account> targetAccount = accountRepository.findById(transactionDTO.getTargetAccountId());

        if(requesterAccount.isEmpty() || targetAccount.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide both Account IDs");
        }

        validateTransaction(transactionDTO);

        Transaction transaction = new Transaction( transactionDTO.getRequesterAccountId(),
                transactionDTO.getTargetAccountId(), transactionDTO.getAmount());

        implementTransaction(transactionDTO);

        applyPenaltyFee(transactionDTO);

        return transactionRepository.save(transaction);
    }


}
