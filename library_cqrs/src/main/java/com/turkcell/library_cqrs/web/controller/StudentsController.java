package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateStudentCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateStudentCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedStudentResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllStudentsQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllStudentsQueryHandler;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllStudentsResponse;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    //Command
    private final CreateStudentCommandHandler createStudentCommandHandler;

    // QUERY
    private final GetAllStudentsQueryHandler getAllStudentsQueryHandler;

    // CONSTRUCTOR
    public StudentsController(
            CreateStudentCommandHandler createStudentCommandHandler,
            GetAllStudentsQueryHandler getAllStudentsQueryHandler) {

        this.createStudentCommandHandler = createStudentCommandHandler;
        this.getAllStudentsQueryHandler = getAllStudentsQueryHandler;
    }

    // CREATE
    @PostMapping
    public CreatedStudentResponse add(
            @RequestBody CreateStudentCommand command) {

        return createStudentCommandHandler.handle(command);
    }

    // GET ALL
    @GetMapping
    public List<GetAllStudentsResponse> getAll() {

        return getAllStudentsQueryHandler.handle(
                new GetAllStudentsQuery()
        );
    }
}