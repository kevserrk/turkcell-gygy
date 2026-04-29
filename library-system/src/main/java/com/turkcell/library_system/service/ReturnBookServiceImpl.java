package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.returnBook.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.BusinessException;
import com.turkcell.library_system.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnBookServiceImpl {

    private final ReturnBookRepository returnBookRepository;
    private final BorrowRepository borrowRepository;
    private final LibraryStaffRepository staffRepository;

    public ReturnBookServiceImpl(ReturnBookRepository returnBookRepository,
                                 BorrowRepository borrowRepository,
                                 LibraryStaffRepository staffRepository) {
        this.returnBookRepository = returnBookRepository;
        this.borrowRepository = borrowRepository;
        this.staffRepository = staffRepository;
    }

    public CreatedReturnBookResponse add(CreateReturnBookRequest request) {

        Borrow borrow = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new BusinessException("Borrow not found","BORROW_NOT_FOUND"));

        LibraryStaff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new BusinessException("Staff not found","STAFF_NOT_FOUND"));

        ReturnBook returnBook = new ReturnBook();
        returnBook.setBorrow(borrow);
        returnBook.setReceivedBy(staff);
        returnBook.setReturnDate(request.getReturnDate());

        ReturnBook saved = returnBookRepository.save(returnBook);

        CreatedReturnBookResponse response = new CreatedReturnBookResponse();
        response.setReturnId(saved.getReturnId());
        response.setBorrowId(borrow.getBorrowId());
        response.setStaffId(staff.getStaffId());
        response.setReturnDate(saved.getReturnDate());

        return response;
    }

    public List<ListReturnBookResponse> getAll() {
        return returnBookRepository.findAll()
                .stream()
                .map(rb -> {
                    ListReturnBookResponse response = new ListReturnBookResponse();

                    response.setReturnId(rb.getReturnId());
                    response.setBookTitle(rb.getBorrow().getBook().getTitle());
                    response.setStudentName(
                            rb.getBorrow().getStudent().getFirstName() + " " +
                            rb.getBorrow().getStudent().getLastName()
                    );
                    response.setStaffName(
                            rb.getReceivedBy().getFirstName() + " " +
                            rb.getReceivedBy().getLastName()
                    );
                    response.setReturnDate(rb.getReturnDate());

                    return response;
                })
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        returnBookRepository.deleteById(id);
    }
}
