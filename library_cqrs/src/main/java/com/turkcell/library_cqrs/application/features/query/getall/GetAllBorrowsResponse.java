package com.turkcell.library_cqrs.application.features.query.getall;

import java.time.LocalDate;

public record GetAllBorrowsResponse(
        int id,
        int studentId,
        int bookId,
        LocalDate borrowDate
) {
}