package com.kata.bank.exception;

public class BusinessException extends Exception{
    public BusinessException() {
        super();
    }

    public BusinessException(String e) {
        super(e);
    }
}
