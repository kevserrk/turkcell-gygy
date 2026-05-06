package com.turkcell.library_cqrs.application.features.command.create;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Book;
import com.turkcell.library_cqrs.domain.ReturnBook;
import com.turkcell.library_cqrs.persistence.repository.BookRepository;
import com.turkcell.library_cqrs.persistence.repository.ReturnBookRepository;

@Component
public class CreateReturnBookCommandHandler
implements CommandHandler<CreateReturnBookCommand, CreatedReturnBookResponse> {

    private final ReturnBookRepository returnBookRepository;
    private final BookRepository bookRepository;

    public CreateReturnBookCommandHandler(ReturnBookRepository returnBookRepository,
                                          BookRepository bookRepository) {

        this.returnBookRepository = returnBookRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public CreatedReturnBookResponse handle(CreateReturnBookCommand command) {

        Book book = bookRepository.findById(command.bookId()).orElseThrow();

        book.setAvailable(true);

        bookRepository.save(book);

        ReturnBook returnBook = new ReturnBook();

        returnBook.setBorrowId(command.borrowId());
        returnBook.setReturnDate(LocalDate.now());

        returnBookRepository.save(returnBook);

        return new CreatedReturnBookResponse(
                returnBook.getId(),
                returnBook.getBorrowId(),
                returnBook.getReturnDate()
        );
    }
}
