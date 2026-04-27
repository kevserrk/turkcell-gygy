package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.student.CreateStudentRequest;
import com.turkcell.library_system.dto.student.UpdateStudentRequest;
import com.turkcell.library_system.dto.student.CreatedStudentResponse;
import com.turkcell.library_system.dto.student.ListStudentResponse;
import com.turkcell.library_system.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public CreatedStudentResponse add(@RequestBody CreateStudentRequest request) {
        return studentService.add(request);
    }

    // GET ALL
    @GetMapping
    public List<ListStudentResponse> getAll() {
        return studentService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ListStudentResponse getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ListStudentResponse update(@PathVariable Integer id,
                                     @RequestBody UpdateStudentRequest request) {
        return studentService.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}