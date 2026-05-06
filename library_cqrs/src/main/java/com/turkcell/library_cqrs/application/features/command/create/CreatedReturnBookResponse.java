package com.turkcell.library_cqrs.application.features.command.create;

import java.time.LocalDate;

public record CreatedReturnBookResponse(
        int id,
        int borrowId,
        LocalDate returnDate
) {
}