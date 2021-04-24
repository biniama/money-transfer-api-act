package com.act.moneytransferapi.services;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.respositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Biniam Asnake
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(String idString) {

        // converting String to Long
        Long idLong = Long.valueOf(idString);

        Optional<Account> accountById = accountRepository.findById(idLong);

        return accountById.orElse(null);
    }
}
