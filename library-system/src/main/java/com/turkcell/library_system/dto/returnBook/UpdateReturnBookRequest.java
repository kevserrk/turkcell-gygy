package com.turkcell.library_system.dto.returnBook;

import java.time.LocalDate;

public class UpdateReturnBookRequest {

    private LocalDate returnDate;

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}