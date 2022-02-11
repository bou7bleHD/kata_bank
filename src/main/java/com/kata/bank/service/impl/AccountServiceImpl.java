package com.kata.bank.service.impl;

import com.kata.bank.data.model.Account;
import com.kata.bank.data.model.Operation;
import com.kata.bank.data.repository.AccountRepository;
import com.kata.bank.exception.ApplicationException;
import com.kata.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findAccountByAccountNumber(String accountNumber) throws ApplicationException {
        try {
            Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
            return account.isPresent()?account.get():null;
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public Account saveAccount(Account account) throws ApplicationException {
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public void deleteAccountById(Long id) throws ApplicationException {
        try {
            accountRepository.deleteById(id);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
