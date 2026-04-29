package com.turkcell.library_system.exception;


import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleBusinessException(BusinessException e){
        return new ErrorResponse(e.getMessage());
    }
}