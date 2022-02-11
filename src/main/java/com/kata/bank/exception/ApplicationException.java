package com.kata.bank.exception;

public class ApplicationException extends Exception{
    public ApplicationException() {
        super();
    }

    public ApplicationException(String e) {
        super(e);
    }
}
