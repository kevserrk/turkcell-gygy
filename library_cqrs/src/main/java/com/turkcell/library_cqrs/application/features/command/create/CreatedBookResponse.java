package com.turkcell.library_cqrs.application.features.command.create;

public record CreatedBookResponse(
        int id,
        String title,
        String author
) {
}