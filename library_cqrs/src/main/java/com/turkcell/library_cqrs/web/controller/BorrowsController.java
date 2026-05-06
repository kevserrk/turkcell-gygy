package com.turkcell.library_cqrs.web.controller;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBorrowCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateBorrowCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBorrowResponse;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {

    private final CreateBorrowCommandHandler createBorrowCommandHandler;

    public BorrowsController(CreateBorrowCommandHandler createBorrowCommandHandler) {
        this.createBorrowCommandHandler = createBorrowCommandHandler;
    }

    @PostMapping
    public CreatedBorrowResponse add(@RequestBody CreateBorrowCommand command) {

        return createBorrowCommandHandler.handle(command);
    }
}