package com.turkcell.library_cqrs.application.features.query.getall;

public record GetAllStudentsResponse(
        int id,
        String firstName,
        String lastName
) {
}
