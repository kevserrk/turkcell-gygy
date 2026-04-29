package com.turkcell.library_system.exception;

public class BookNotFoundException extends BusinessException {

    public BookNotFoundException() {
        super("Book not found", "BOOK_NOT_FOUND");
    }
}
