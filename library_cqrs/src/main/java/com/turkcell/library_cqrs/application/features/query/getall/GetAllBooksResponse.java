package com.turkcell.library_cqrs.application.features.query.getall;

public record GetAllBooksResponse(
        int id,
        String title,
        String author,
        boolean available
) {
}