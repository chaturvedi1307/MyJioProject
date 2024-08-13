package com.BankingSystem.BankingManagementApp.service;
import com.BankingSystem.BankingManagementApp.entity.Account;
import com.BankingSystem.BankingManagementApp.repo.AccountReposirty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceimpl  implements AccountService {

    @Autowired
    AccountReposirty repo;
    @Override
    public Account createAccount(Account account){
        Account account_Saved = repo.save(account);
        return account_Saved;
    };
    @Override
    public Account getAccountDetailsByAccountNumber(Long id){
         Optional<Account> account =  repo.findById(id);
         if(account.isEmpty()){
             throw new RuntimeException("Account is not present");
         }
         Account account_found = account.get();
           return account_found;
    };

    @Override
    public List<Account> getAllAccountDetails(){
       List<Account> account_details =  repo.findAll();
        return account_details;
    };

    @Override
    public Account depositMoney(Long accountNumber, Double amount){
       Optional<Account> account = repo.findById(accountNumber);
       if(account.isEmpty()){
           throw new RuntimeException("Account is not present");

       }
       Account accountPresent = account.get();
       Double totalBalance = accountPresent.getAccount_balance()+amount;
       accountPresent.setAccount_balance(totalBalance);
       repo.save(accountPresent);

       return accountPresent;
        //return null;
    };

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount){
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");

        }
        Account presentAccountBallance = account.get();
        Double totalBalane = account.get().getAccount_balance() - amount;
        presentAccountBallance.setAccount_balance(totalBalane);
        repo.save(presentAccountBallance);
        return presentAccountBallance;
    };

    @Override
    public void closeAccount(Long accountNumber){
        getAccountDetailsByAccountNumber(accountNumber);
        repo.deleteById(accountNumber);

    };
}
