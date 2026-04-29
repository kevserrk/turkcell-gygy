package com.turkcell.spring_starter.exception;

import com.turkcell.spring_starter.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException ex) {
        return new ErrorResponse(
                "Business Error",
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDatabaseException() {
        return new ErrorResponse(
                "Database Error",
                "UniqueConstraint",
                "Bu veri zaten kayıtlı!"
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException() {
        return new ErrorResponse(
            "Validation Error",
            "InvalidRequest",
            "Gönderilen veriler hatalı"
    );
    }

    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex) {
        return new ErrorResponse(
                "System Error",
                "Exception",
                ex.getMessage()
        );
    }
}
