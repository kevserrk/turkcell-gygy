package com.turkcell.library_cqrs.web.controller;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateBookCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBookResponse;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final CreateBookCommandHandler createBookCommandHandler;

    public BooksController(CreateBookCommandHandler createBookCommandHandler) {
        this.createBookCommandHandler = createBookCommandHandler;
    }

    @PostMapping
    public CreatedBookResponse add(@RequestBody CreateBookCommand command) {

        return createBookCommandHandler.handle(command);
    }
}
