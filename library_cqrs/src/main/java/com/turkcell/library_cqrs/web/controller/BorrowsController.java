package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateBorrowCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateBorrowCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedBorrowResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllBorrowsQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBorrowsQueryHandler;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllBorrowsResponse;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {

    
    private final CreateBorrowCommandHandler createBorrowCommandHandler;

    // QUERY
    private final GetAllBorrowsQueryHandler getAllBorrowsQueryHandler;

    
    public BorrowsController(
            CreateBorrowCommandHandler createBorrowCommandHandler,
            GetAllBorrowsQueryHandler getAllBorrowsQueryHandler) {

        this.createBorrowCommandHandler = createBorrowCommandHandler;
        this.getAllBorrowsQueryHandler = getAllBorrowsQueryHandler;
    }

    // CREATE
    @PostMapping
    public CreatedBorrowResponse add(
            @RequestBody CreateBorrowCommand command) {

        return createBorrowCommandHandler.handle(command);
    }

    // GET ALL
    @GetMapping
    public List<GetAllBorrowsResponse> getAll() {

        return getAllBorrowsQueryHandler.handle(
                new GetAllBorrowsQuery()
        );
    }
}