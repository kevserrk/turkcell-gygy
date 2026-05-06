package com.turkcell.library_cqrs.application.features.command.create;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Student;
import com.turkcell.library_cqrs.persistence.repository.StudentRepository;

@Component
public class CreateStudentCommandHandler
        implements CommandHandler<CreateStudentCommand, CreatedStudentResponse> {

    private final StudentRepository studentRepository;

    public CreateStudentCommandHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CreatedStudentResponse handle(CreateStudentCommand command) {

        Student student = new Student();

        student.setFirstName(command.firstName());
        student.setLastName(command.lastName());

        studentRepository.save(student);

        return new CreatedStudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName()
        );
    }
}