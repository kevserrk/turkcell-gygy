package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.student.CreateStudentRequest;
import com.turkcell.library_system.dto.student.UpdateStudentRequest;
import com.turkcell.library_system.dto.student.CreatedStudentResponse;
import com.turkcell.library_system.dto.student.ListStudentResponse;
import com.turkcell.library_system.entity.Student;
import com.turkcell.library_system.exception.BusinessException;
import com.turkcell.library_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public CreatedStudentResponse add(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());

        Student saved = studentRepository.save(student);

        CreatedStudentResponse response = new CreatedStudentResponse();
        response.setStudentId(saved.getStudentId());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setEmail(saved.getEmail());

        return response;
    }

    //  GET ALL
    public List<ListStudentResponse> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> {
                    ListStudentResponse response = new ListStudentResponse();
                    response.setStudentId(student.getStudentId());
                    response.setFirstName(student.getFirstName());
                    response.setLastName(student.getLastName());
                    response.setEmail(student.getEmail());
                    return response;
                })
                .collect(Collectors.toList());
    }

    //  GET BY ID
    public ListStudentResponse getById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Student not found","STUDENT_NOT_FOUND"));

        ListStudentResponse response = new ListStudentResponse();
        response.setStudentId(student.getStudentId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());

        return response;
    }

    // UPDATE
    public ListStudentResponse update(Integer id, UpdateStudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Student not found","STUDENT_NOT_FOUND"));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());

        Student updated = studentRepository.save(student);

        ListStudentResponse response = new ListStudentResponse();
        response.setStudentId(updated.getStudentId());
        response.setFirstName(updated.getFirstName());
        response.setLastName(updated.getLastName());
        response.setEmail(updated.getEmail());

        return response;
    }

    // DELETE
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}