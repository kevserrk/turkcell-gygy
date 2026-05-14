package com.turkcell.spring_cqrs.core.security.exception;

public class AuthenticatedException extends RuntimeException {

    public AuthenticatedException(String message) {
        super(message);
    }
}