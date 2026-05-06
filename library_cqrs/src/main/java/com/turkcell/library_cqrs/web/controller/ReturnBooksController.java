package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateReturnBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateReturnBookCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedReturnBookResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllReturnBooksQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllReturnBooksQueryHandler;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllReturnBooksResponse;

@RestController
@RequestMapping("/api/returns")
public class ReturnBooksController {

    // COMMAND
    private final CreateReturnBookCommandHandler createReturnBookCommandHandler;

    // QUERY
    private final GetAllReturnBooksQueryHandler getAllReturnBooksQueryHandler;

    // CONSTRUCTOR
    public ReturnBooksController(
            CreateReturnBookCommandHandler createReturnBookCommandHandler,
            GetAllReturnBooksQueryHandler getAllReturnBooksQueryHandler) {

        this.createReturnBookCommandHandler = createReturnBookCommandHandler;
        this.getAllReturnBooksQueryHandler = getAllReturnBooksQueryHandler;
    }

    // CREATE
    @PostMapping
    public CreatedReturnBookResponse add(
            @RequestBody CreateReturnBookCommand command) {

        return createReturnBookCommandHandler.handle(command);
    }

    // GET ALL
    @GetMapping
    public List<GetAllReturnBooksResponse> getAll() {

        return getAllReturnBooksQueryHandler.handle(
                new GetAllReturnBooksQuery()
        );
    }
}