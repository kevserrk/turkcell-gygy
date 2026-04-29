package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.borrow.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.BusinessException;
import com.turkcell.library_system.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final LibraryStaffRepository staffRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository,
                             BookRepository bookRepository,
                             StudentRepository studentRepository,
                             LibraryStaffRepository staffRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
    }

    public CreatedBorrowResponse add(CreateBorrowRequest request) {

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new BusinessException("Student not found","STUDENT_NOT_FOUND"));

        LibraryStaff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new BusinessException("Staff not found","STAFF_NOT_FOUND"));

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setStudent(student);
        borrow.setIssuedBy(staff);
        
        borrow.setBorrowDate(request.getBorrowDate()); 

        Borrow saved = borrowRepository.save(borrow);

        CreatedBorrowResponse response = new CreatedBorrowResponse();
        
        response.setBorrowId(saved.getBorrowId());
        response.setBookId(book.getBookId());
        response.setStudentId(student.getStudentId());
        
        response.setBorrowDate(saved.getBorrowDate());

        return response;
    }

    public List<ListBorrowResponse> getAll() {
        return borrowRepository.findAll()
                .stream()
                .map(borrow -> {
                    ListBorrowResponse response = new ListBorrowResponse();

                    
                    response.setBorrowId(borrow.getBorrowId());
                    response.setBookTitle(borrow.getBook().getTitle());
                    response.setStudentName(
                            borrow.getStudent().getFirstName() + " " +
                            borrow.getStudent().getLastName()
                    );
                    response.setBorrowDate(borrow.getBorrowDate());

                    return response;
                })
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        borrowRepository.deleteById(id);
    }
}