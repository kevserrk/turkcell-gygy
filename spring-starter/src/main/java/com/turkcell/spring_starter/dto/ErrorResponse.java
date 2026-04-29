package com.turkcell.spring_starter.dto;

public class ErrorResponse {

    private String title;
    private String type;
    private String message;

    public ErrorResponse(String title, String type, String message) {
        this.title = title;
        this.type = type;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}