package com.kata.bank.web;

import com.kata.bank.data.model.Account;
import com.kata.bank.exception.ApplicationException;
import com.kata.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/find/{accountNumber}")
    public ResponseEntity<Account> findAccountByAccountNumber (@PathVariable("accountNumber") String accountNumber) throws ApplicationException {
        Account account = accountService.findAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Account> addAccount( @RequestBody Account account) throws ApplicationException {
        Account newAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
    @PostMapping("/delete")
    public void deleteAccount(@PathVariable("id") Long id) throws ApplicationException {
        accountService.deleteAccountById(id);
    }
}
