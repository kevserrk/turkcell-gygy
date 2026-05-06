package com.turkcell.library_cqrs.application.features.query.getall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.Book;
import com.turkcell.library_cqrs.persistence.repository.BookRepository;

@Component
public class GetAllBooksQueryHandler
implements QueryHandler<GetAllBooksQuery,
        List<GetAllBooksResponse>> {

    private final BookRepository bookRepository;

    public GetAllBooksQueryHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<GetAllBooksResponse> handle(GetAllBooksQuery query) {

        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> new GetAllBooksResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.isAvailable()
                ))
                .toList();
    }
}