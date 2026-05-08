package com.turkcell.library_cqrs.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateStudentCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreatedStudentResponse;

import com.turkcell.library_cqrs.application.features.query.getall.GetAllStudentsQuery;
import com.turkcell.library_cqrs.application.features.query.getall.GetAllStudentsResponse;

import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final Mediator mediator;

    public StudentsController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedStudentResponse add(
            @RequestBody CreateStudentCommand command) {

        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllStudentsResponse> getAll() {

        return mediator.send(
                new GetAllStudentsQuery()
        );
    }
}