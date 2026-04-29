package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.fine.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.BusinessException;
import com.turkcell.library_system.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineServiceImpl {

    private final FineRepository fineRepository;
    private final StudentRepository studentRepository;
    private final BorrowRepository borrowRepository;

    public FineServiceImpl(FineRepository fineRepository,
                           StudentRepository studentRepository,
                           BorrowRepository borrowRepository) {
        this.fineRepository = fineRepository;
        this.studentRepository = studentRepository;
        this.borrowRepository = borrowRepository;
    }

    public CreatedFineResponse add(CreateFineRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new BusinessException("Student not found","STUDENT_NOT_FOUND"));

        Borrow borrow = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new BusinessException("Borrow not found","BORROW_NOT_FOUND"));

        Fine fine = new Fine();
        fine.setStudent(student);
        fine.setBorrow(borrow);
        fine.setFineDate(request.getFineDate());
        fine.setFineAmount(request.getFineAmount());

        Fine saved = fineRepository.save(fine);

        CreatedFineResponse response = new CreatedFineResponse();
        response.setFineId(saved.getFineId());
        response.setStudentId(student.getStudentId());
        response.setBorrowId(borrow.getBorrowId());
        response.setFineDate(saved.getFineDate());
        response.setFineAmount(saved.getFineAmount());

        return response;
    }

    public List<ListFineResponse> getAll() {
        return fineRepository.findAll()
                .stream()
                .map(fine -> {
                    ListFineResponse response = new ListFineResponse();

                    response.setFineId(fine.getFineId());
                    response.setStudentName(
                            fine.getStudent().getFirstName() + " " +
                            fine.getStudent().getLastName()
                    );
                    response.setBookTitle(
                            fine.getBorrow().getBook().getTitle()
                    );
                    response.setFineDate(fine.getFineDate());
                    response.setFineAmount(fine.getFineAmount());

                    return response;
                })
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        fineRepository.deleteById(id);
    }
}