package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateReturnBookCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreatedReturnBookResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllReturnBooksQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllReturnBooksResponse;

import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/returns")
public class ReturnBooksController {

    private final Mediator mediator;

    public ReturnBooksController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedReturnBookResponse add(
            @RequestBody CreateReturnBookCommand command) {

        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllReturnBooksResponse> getAll() {

        return mediator.send(
                new GetAllReturnBooksQuery()
        );
    }
}