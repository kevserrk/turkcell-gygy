package com.turkcell.library_cqrs.application.features.command.create;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Book;
import com.turkcell.library_cqrs.domain.Borrow;
import com.turkcell.library_cqrs.persistence.repository.BookRepository;
import com.turkcell.library_cqrs.persistence.repository.BorrowRepository;

@Component
public class CreateBorrowCommandHandler
        implements CommandHandler<CreateBorrowCommand, CreatedBorrowResponse> {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    public CreateBorrowCommandHandler(BorrowRepository borrowRepository,
                                      BookRepository bookRepository) {

        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public CreatedBorrowResponse handle(CreateBorrowCommand command) {

        Book book = bookRepository.findById(command.bookId()).orElseThrow();

        book.setAvailable(false);

        bookRepository.save(book);

        Borrow borrow = new Borrow();

        borrow.setStudentId(command.studentId());
        borrow.setBookId(command.bookId());
        borrow.setBorrowDate(LocalDate.now());

        borrowRepository.save(borrow);

        return new CreatedBorrowResponse(
                borrow.getId(),
                borrow.getStudentId(),
                borrow.getBookId(),
                borrow.getBorrowDate()
        );
    }
}