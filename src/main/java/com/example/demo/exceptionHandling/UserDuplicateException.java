package com.example.demo.exceptionHandling;

public class UserDuplicateException extends RuntimeException {

    public UserDuplicateException (String message) {
        super(message);
    }
}
