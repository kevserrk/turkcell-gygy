package com.turkcell.library_cqrs.application.features.query.getall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.ReturnBook;
import com.turkcell.library_cqrs.persistence.repository.ReturnBookRepository;

@Component
public class GetAllReturnBooksQueryHandler
implements QueryHandler<GetAllReturnBooksQuery,
        List<GetAllReturnBooksResponse>> {

    private final ReturnBookRepository returnBookRepository;

    public GetAllReturnBooksQueryHandler(
            ReturnBookRepository returnBookRepository) {

        this.returnBookRepository = returnBookRepository;
    }

    @Override
    public List<GetAllReturnBooksResponse> handle(
            GetAllReturnBooksQuery query) {

        List<ReturnBook> returns = returnBookRepository.findAll();

        return returns.stream()
                .map(returnBook -> new GetAllReturnBooksResponse(
                        returnBook.getId(),
                        returnBook.getBorrowId(),
                        returnBook.getReturnDate()
                ))
                .toList();
    }
}