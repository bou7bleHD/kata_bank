package com.kata.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KataExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity blogNotFoundException(BusinessException businessException) {
        return new ResponseEntity(businessException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity blogNotFoundException(ApplicationException applicationException) {
        return new ResponseEntity(applicationException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity blogNotFoundException(Exception applicationException) {
        return new ResponseEntity(applicationException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
