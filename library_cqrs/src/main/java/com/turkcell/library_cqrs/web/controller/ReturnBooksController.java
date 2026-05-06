package com.turkcell.library_cqrs.web.controller;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateReturnBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateReturnBookCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedReturnBookResponse;

@RestController
@RequestMapping("/api/returns")
public class ReturnBooksController {

    private final CreateReturnBookCommandHandler createReturnBookCommandHandler;

    public ReturnBooksController(CreateReturnBookCommandHandler createReturnBookCommandHandler) {
        this.createReturnBookCommandHandler = createReturnBookCommandHandler;
    }

    @PostMapping
    public CreatedReturnBookResponse add(
            @RequestBody CreateReturnBookCommand command) {

        return createReturnBookCommandHandler.handle(command);
    }
}