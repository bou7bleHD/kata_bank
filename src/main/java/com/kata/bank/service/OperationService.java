package com.kata.bank.service;

import com.kata.bank.data.model.Operation;
import com.kata.bank.exception.ApplicationException;

import java.util.List;
import java.util.Optional;

public interface OperationService {
    Operation findOperationById(Long id) throws ApplicationException;
    Operation saveOperation(Operation operation) throws ApplicationException;
    List<Operation> findOperationsByAccountNumber(String accountNumber) throws ApplicationException;

}
