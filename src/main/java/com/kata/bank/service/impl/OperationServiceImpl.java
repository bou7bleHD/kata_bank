package com.kata.bank.service.impl;

import com.kata.bank.data.model.Operation;
import com.kata.bank.data.repository.OperationRepository;
import com.kata.bank.exception.ApplicationException;
import com.kata.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    OperationRepository operationRepository;


    @Override
    public Operation findOperationById(Long id) throws ApplicationException {
        try {
            Optional<Operation> operation = operationRepository.findById(id);
            return operation.isPresent() ? operation.get() : null;
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public Operation saveOperation(Operation operation) throws ApplicationException {
        try {
            return operationRepository.save(operation);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<Operation> findOperationsByAccountNumber(String accountNumber) throws ApplicationException {
        try {
            return operationRepository.findOperationsByAccountNumber(accountNumber);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
