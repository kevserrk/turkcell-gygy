package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBorrowCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBorrowResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllBorrowsQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBorrowsResponse;

import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {

    private final Mediator mediator;

    public BorrowsController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedBorrowResponse add(
            @RequestBody CreateBorrowCommand command) {

        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllBorrowsResponse> getAll() {

        return mediator.send(
                new GetAllBorrowsQuery()
        );
    }
}