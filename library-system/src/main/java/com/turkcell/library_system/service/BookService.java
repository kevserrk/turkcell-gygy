package com.turkcell.library_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.book.*;
import com.turkcell.library_system.entity.Author;
import com.turkcell.library_system.entity.Book;
import com.turkcell.library_system.repository.AuthorRepository;
import com.turkcell.library_system.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public CreatedBookResponse create(CreateBookRequest request) {

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPublicationYear(request.getPublicationYear());
        book.setCopiesTotal(request.getCopiesTotal());

        List<Author> authors = authorRepository.findAllById(request.getAuthorIds());
        book.setAuthors(authors);

        book = bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());

        return response;
    }

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
}