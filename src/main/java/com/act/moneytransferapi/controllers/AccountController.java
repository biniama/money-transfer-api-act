package com.act.moneytransferapi.controllers;

import com.act.moneytransferapi.domains.Account;
import com.act.moneytransferapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
