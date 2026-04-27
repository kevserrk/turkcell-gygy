package com.turkcell.library_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.author.*;
import com.turkcell.library_system.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public CreatedAuthorResponse create(@RequestBody CreateAuthorRequest request) {
        return authorService.create(request);
    }

    @GetMapping
    public List<ListAuthorResponse> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public ListAuthorResponse getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PutMapping("/{id}")
    public CreatedAuthorResponse update(@RequestBody UpdateAuthorRequest request,
                                        @PathVariable Long id) {
        return authorService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
