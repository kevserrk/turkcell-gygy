package com.turkcell.library_cqrs.application.features.command.create;

import java.time.LocalDate;

public record CreatedBorrowResponse(
        int id,
        int studentId,
        int bookId,
        LocalDate borrowDate
) {
}
