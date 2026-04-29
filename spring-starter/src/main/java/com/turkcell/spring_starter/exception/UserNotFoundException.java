package com.turkcell.spring_starter.exception;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
