package com.kata.bank.web;

import com.kata.bank.exception.ApplicationException;
import com.kata.bank.exception.BusinessException;
import com.kata.bank.data.model.Account;
import com.kata.bank.data.model.CodeOperationEnum;
import com.kata.bank.data.model.Operation;
import com.kata.bank.service.AccountService;
import com.kata.bank.service.OperationService;
import com.kata.bank.web.wrapper.OperationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    AccountService accountService;

    @GetMapping("/{accountNumber}/all")
    public ResponseEntity<List<Operation>> findOperationsByAccountNumber (@PathVariable("accountNumber") String accountNumber) throws ApplicationException {
        List<Operation> operations = operationService.findOperationsByAccountNumber(accountNumber);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Operation> getOperationById (@PathVariable("id") Long id) throws ApplicationException {
        Operation operation = operationService.findOperationById(id);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Operation> addOperation( @RequestBody OperationWrapper operationWrapper) throws BusinessException, ApplicationException {
            Account account = accountService.findAccountByAccountNumber(operationWrapper.getAccountNumber());
            Operation newOperation = operationWrapper.getOperation();
            newOperation.setAccount(account);
            //compute new balance account
            computeNewBalance(account, newOperation.getAmount(), newOperation.getCodeOperation().name());
            //save operation & account
            newOperation = operationService.saveOperation(newOperation);
            accountService.saveAccount(account);
            return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }

    private void computeNewBalance(Account account,double amount,String codeOperation) throws BusinessException {
        if (CodeOperationEnum.DEPOSIT.name().equals(codeOperation)) {
            account.setBalance(account.getBalance() + amount);
        } else if (CodeOperationEnum.WITHDRAW.name().equals(codeOperation)) {
            if(account.getBalance() > amount)
                account.setBalance(account.getBalance() - amount);
            else
                throw new BusinessException("Solde insuffisant");
        }
    }

    private boolean validateCodeOperation(String codeOperation) {
        if(CodeOperationEnum.WITHDRAW.name().equals(codeOperation) || CodeOperationEnum.DEPOSIT.name().equals(codeOperation)) {
            return true;
        }
        return false;
    }
}
