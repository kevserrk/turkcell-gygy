package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.book.CreateBookRequest;
import com.turkcell.library_system.dto.book.UpdateBookRequest;
import com.turkcell.library_system.dto.book.CreatedBookResponse;
import com.turkcell.library_system.dto.book.ListBookResponse;
import com.turkcell.library_system.service.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public CreatedBookResponse add(@RequestBody CreateBookRequest request) {
        return bookService.add(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public ListBookResponse getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @PutMapping("/{id}")
    public ListBookResponse update(@PathVariable Integer id,
                                  @RequestBody UpdateBookRequest request) {
        return bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }
}
