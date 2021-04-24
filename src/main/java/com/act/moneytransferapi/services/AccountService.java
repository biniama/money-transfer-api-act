package com.act.moneytransferapi.services;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.respositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
