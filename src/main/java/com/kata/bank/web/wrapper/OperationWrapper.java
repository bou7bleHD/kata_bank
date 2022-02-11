package com.kata.bank.web.wrapper;

import com.kata.bank.data.model.Operation;

public class OperationWrapper {
    private Operation operation;
    private String accountNumber;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
