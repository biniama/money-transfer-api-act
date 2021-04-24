package com.act.moneytransferapi.controllers;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Biniam Asnake
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create", produces = "application/json")
    public Account createAccount(@RequestBody Account accountRequest) {
        return accountService.createAccount(accountRequest);
    }

    @GetMapping("/list")
    public Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/show/{id}")
    public Account getAccountById(@PathVariable("id") String id) {
        return accountService.getAccountById(id);
    }
}
