package com.turkcell.library_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.book.CreateBookRequest;
import com.turkcell.library_system.dto.book.CreatedBookResponse;
import com.turkcell.library_system.dto.book.ListBookResponse;
import com.turkcell.library_system.dto.book.UpdateBookRequest;
import com.turkcell.library_system.entity.Book;
import com.turkcell.library_system.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public CreatedBookResponse create(CreateBookRequest request) {

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPublicationYear(request.getPublicationYear());
        book.setCopiesTotal(request.getCopiesTotal());

        book = bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPublicationYear(book.getPublicationYear());
        response.setCopiesTotal(book.getCopiesTotal());

        return response;
    }

    // GET ALL
    public List<ListBookResponse> getAll() {

        List<Book> books = bookRepository.findAll();

        List<ListBookResponse> responseList = new ArrayList<>();

        for (Book book : books) {
            ListBookResponse response = new ListBookResponse();
            response.setBookId(book.getBookId());
            response.setTitle(book.getTitle());
            response.setPublicationYear(book.getPublicationYear());
            response.setCopiesTotal(book.getCopiesTotal());
            responseList.add(response);
        }

        return responseList;
    }

    // GET BY ID
    public ListBookResponse getById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        ListBookResponse response = new ListBookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPublicationYear(book.getPublicationYear());
        response.setCopiesTotal(book.getCopiesTotal());

        return response;
    }

    // UPDATE
    public CreatedBookResponse update(UpdateBookRequest request, Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        book.setTitle(request.getTitle());
        book.setPublicationYear(request.getPublicationYear());
        book.setCopiesTotal(request.getCopiesTotal());

        book = bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPublicationYear(book.getPublicationYear());
        response.setCopiesTotal(book.getCopiesTotal());

        return response;
    }

    // DELETE
    public void delete(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        bookRepository.delete(book);
    }
}
