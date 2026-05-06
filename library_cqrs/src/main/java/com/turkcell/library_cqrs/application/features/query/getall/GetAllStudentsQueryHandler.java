package com.turkcell.library_cqrs.application.features.query.getall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.Student;
import com.turkcell.library_cqrs.persistence.repository.StudentRepository;

@Component
public class GetAllStudentsQueryHandler
implements QueryHandler<GetAllStudentsQuery,
        List<GetAllStudentsResponse>> {

    private final StudentRepository studentRepository;

    public GetAllStudentsQueryHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<GetAllStudentsResponse> handle(GetAllStudentsQuery query) {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new GetAllStudentsResponse(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName()
                ))
                .toList();
    }
}