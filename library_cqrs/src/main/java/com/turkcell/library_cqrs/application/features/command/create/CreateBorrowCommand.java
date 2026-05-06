package com.turkcell.library_cqrs.application.features.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record CreateBorrowCommand(
        int studentId,
        int bookId
) implements Command<CreatedBorrowResponse> {
}