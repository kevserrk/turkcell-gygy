package com.turkcell.library_cqrs.web.controller;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.command.create.CreateStudentCommand;
import com.turkcell.library_cqrs.application.features.command.create.CreateStudentCommandHandler;
import com.turkcell.library_cqrs.application.features.command.create.CreatedStudentResponse;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final CreateStudentCommandHandler createStudentCommandHandler;

    public StudentsController(CreateStudentCommandHandler createStudentCommandHandler) {
        this.createStudentCommandHandler = createStudentCommandHandler;
    }

    @PostMapping
    public CreatedStudentResponse add(@RequestBody CreateStudentCommand command) {

        return createStudentCommandHandler.handle(command);
    }
}