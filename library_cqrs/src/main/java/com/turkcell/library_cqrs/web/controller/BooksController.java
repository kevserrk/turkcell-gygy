package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBookResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllBooksQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBooksResponse;

import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final Mediator mediator;

    public BooksController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedBookResponse add(
            @RequestBody CreateBookCommand command) {

        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllBooksResponse> getAll() {

        return mediator.send(
                new GetAllBooksQuery()
        );
    }
}