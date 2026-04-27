package com.turkcell.library_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.book.*;
import com.turkcell.library_system.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public CreatedBookResponse create(@RequestBody CreateBookRequest request) {
        return bookService.create(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ListBookResponse getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PutMapping("/{id}")
    public CreatedBookResponse update(@RequestBody UpdateBookRequest request,
                                      @PathVariable Long id) {
        return bookService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}