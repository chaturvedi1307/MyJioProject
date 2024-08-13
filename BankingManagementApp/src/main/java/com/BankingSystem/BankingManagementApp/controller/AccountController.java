package com.BankingSystem.BankingManagementApp.controller;
import com.BankingSystem.BankingManagementApp.entity.Account;
import com.BankingSystem.BankingManagementApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;
    //create the account
    @PostMapping("/create")
    public ResponseEntity<Account>  createAccount(@RequestBody Account account){
        service .createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);

    }


    //get account details by account number
    @GetMapping("/{id}")
    public ResponseEntity<Account> getBankDetailsByAccountNumber(@PathVariable Long id){
              Account account =  service.getAccountDetailsByAccountNumber(id);

        return ResponseEntity.status(HttpStatus.OK).body(account);

    }

    @GetMapping("/getAllDetails")
    public List<Account> getAllAccountdetail( ){
       List<Account> allAccountdetl =  service.getAllAccountDetails();

       return allAccountdetl;
    }


    //code of depositing the account balance in the account
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAmount(@PathVariable  Long accountNumber, @PathVariable  Double amount){
        Account account = service.depositMoney(accountNumber, amount);
        return account;
    }



    // code for withdraw money form the particular account
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber , @PathVariable Double amount){
        Account account = service.withdrawAmount(accountNumber, amount);
        return account;
    }


    // code for closing the account
    @DeleteMapping("/deleteAccount/{accountNumber}")
    public ResponseEntity<String> deleteccount(@PathVariable Long accountNumber){
       service.closeAccount(accountNumber);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account closed");
    }

}
