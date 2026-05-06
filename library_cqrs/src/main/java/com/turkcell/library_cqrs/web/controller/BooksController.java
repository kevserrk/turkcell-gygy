package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateBookCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBookResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllBooksQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBooksQueryHandler;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBooksResponse;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    // COMMAND
    private final CreateBookCommandHandler createBookCommandHandler;

    // QUERY
    private final GetAllBooksQueryHandler getAllBooksQueryHandler;

    // CONSTRUCTOR
    public BooksController(
            CreateBookCommandHandler createBookCommandHandler,
            GetAllBooksQueryHandler getAllBooksQueryHandler) {

        this.createBookCommandHandler = createBookCommandHandler;
        this.getAllBooksQueryHandler = getAllBooksQueryHandler;
    }

    // CREATE
    @PostMapping
    public CreatedBookResponse add(
            @RequestBody CreateBookCommand command) {

        return createBookCommandHandler.handle(command);
    }

    // GET ALL
    @GetMapping
    public List<GetAllBooksResponse> getAll() {

        return getAllBooksQueryHandler.handle(
                new GetAllBooksQuery()
        );
    }
}