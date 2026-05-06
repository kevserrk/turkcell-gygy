package com.turkcell.library_cqrs.application.features.query.getall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.Borrow;
import com.turkcell.library_cqrs.persistence.repository.BorrowRepository;

@Component
public class GetAllBorrowsQueryHandler
implements QueryHandler<GetAllBorrowsQuery,
        List<GetAllBorrowsResponse>> {

    private final BorrowRepository borrowRepository;

    public GetAllBorrowsQueryHandler(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public List<GetAllBorrowsResponse> handle(GetAllBorrowsQuery query) {

        List<Borrow> borrows = borrowRepository.findAll();

        return borrows.stream()
                .map(borrow -> new GetAllBorrowsResponse(
                        borrow.getId(),
                        borrow.getStudentId(),
                        borrow.getBookId(),
                        borrow.getBorrowDate()
                ))
                .toList();
    }
}