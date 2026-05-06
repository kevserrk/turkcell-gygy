package com.turkcell.library_cqrs.application.features.query.getall;

import java.time.LocalDate;

public record GetAllReturnBooksResponse(
        int id,
        int borrowId,
        LocalDate returnDate
) {
}