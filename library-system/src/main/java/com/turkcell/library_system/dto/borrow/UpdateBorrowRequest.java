package com.turkcell.library_system.dto.borrow;

import java.time.LocalDate;

public class UpdateBorrowRequest {

    private LocalDate borrowDate;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}