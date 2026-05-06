package com.turkcell.library_cqrs.application.features.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record CreateBookCommand(
        String title,
        String author
) implements Command<CreatedBookResponse> {
}