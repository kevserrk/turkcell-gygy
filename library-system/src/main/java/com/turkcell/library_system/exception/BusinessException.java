package com.turkcell.library_system.exception;

public class BusinessException extends RuntimeException {

    private String type;

    public BusinessException(String message, String type) {
        super(message);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}