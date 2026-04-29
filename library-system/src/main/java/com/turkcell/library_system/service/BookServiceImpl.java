package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.book.CreateBookRequest;
import com.turkcell.library_system.dto.book.UpdateBookRequest;
import com.turkcell.library_system.dto.book.CreatedBookResponse;
import com.turkcell.library_system.dto.book.ListBookResponse;
import com.turkcell.library_system.entity.Book;
import com.turkcell.library_system.exception.BookNotFoundException;
import com.turkcell.library_system.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public CreatedBookResponse add(CreateBookRequest request) {
        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setPublicationYear(request.getPublicationYear());
        book.setCopiesTotal(request.getCopiesTotal());

        Book saved = bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setBookId(saved.getBookId());
        response.setTitle(saved.getTitle());
        response.setPublicationYear(saved.getPublicationYear());
        response.setCopiesTotal(saved.getCopiesTotal());

        return response;
    }

    // GET ALL
    public List<ListBookResponse> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(book -> {
                    ListBookResponse response = new ListBookResponse();
                    response.setBookId(book.getBookId());
                    response.setTitle(book.getTitle());
                    response.setPublicationYear(book.getPublicationYear());
                    response.setCopiesTotal(book.getCopiesTotal());
                    return response;
                })
                .collect(Collectors.toList());
    }

    //  GET BY ID
    public ListBookResponse getById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());

        ListBookResponse response = new ListBookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPublicationYear(book.getPublicationYear());
        response.setCopiesTotal(book.getCopiesTotal());

        return response;
    }

    // UPDATE
    public ListBookResponse update(Integer id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());

        book.setTitle(request.getTitle());
        book.setPublicationYear(request.getPublicationYear());
        book.setCopiesTotal(request.getCopiesTotal());

        Book updated = bookRepository.save(book);

        ListBookResponse response = new ListBookResponse();
        response.setBookId(updated.getBookId());
        response.setTitle(updated.getTitle());
        response.setPublicationYear(updated.getPublicationYear());
        response.setCopiesTotal(updated.getCopiesTotal());

        return response;
    }

    //  DELETE
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
