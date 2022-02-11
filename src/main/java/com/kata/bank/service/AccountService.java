package com.kata.bank.service;

import com.kata.bank.data.model.Account;
import com.kata.bank.exception.ApplicationException;

public interface AccountService {
    Account findAccountByAccountNumber(String accountNumber) throws ApplicationException;
    Account saveAccount(Account account) throws ApplicationException;
    void deleteAccountById(Long id) throws ApplicationException;
}
