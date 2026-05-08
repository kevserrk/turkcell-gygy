package com.turkcell.library_cqrs.application.features.command.create;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Book;
import com.turkcell.library_cqrs.persistence.repository.BookRepository;

@Component
public class CreateBookCommandHandler
        implements CommandHandler<CreateBookCommand, CreatedBookResponse> {

    private final BookRepository bookRepository;

    public CreateBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public CreatedBookResponse handle(CreateBookCommand command) {
        

        Book book = new Book();

        book.setTitle(command.title());
        book.setAuthor(command.author());
        book.setAvailable(true);

        bookRepository.save(book);

        return new CreatedBookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor()
        );
    }
}