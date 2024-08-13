package com.BankingSystem.BankingManagementApp.repo;

import com.BankingSystem.BankingManagementApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountReposirty extends JpaRepository<Account, Long> {

}
