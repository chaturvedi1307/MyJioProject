package com.BankingSystem.BankingManagementApp.service;

import com.BankingSystem.BankingManagementApp.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositMoney(Long accountNumber, Double amount);
    public Account withdrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);

}
