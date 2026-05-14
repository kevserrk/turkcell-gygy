package com.turkcell.spring_cqrs.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.turkcell.spring_cqrs.core.security.exception.AuthenticatedException;
import com.turkcell.spring_cqrs.core.security.exception.AuthorizationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticatedException.class)
    public ResponseEntity<String> handleAuthentication(
            AuthenticatedException ex)
    {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<String> handleAuthorization(
            AuthorizationException ex)
    {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ex.getMessage());
    }
}
