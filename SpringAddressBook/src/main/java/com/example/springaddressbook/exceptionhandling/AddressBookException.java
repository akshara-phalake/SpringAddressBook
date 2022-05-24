package com.example.springaddressbook.exceptionhandling;

public class AddressBookException extends RuntimeException {
    public AddressBookException(String message) {
        super(message);
    }
}

