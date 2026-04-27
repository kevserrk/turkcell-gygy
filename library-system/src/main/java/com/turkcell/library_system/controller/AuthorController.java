package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.author.CreateAuthorRequest;
import com.turkcell.library_system.dto.author.UpdateAuthorRequest;
import com.turkcell.library_system.dto.author.CreatedAuthorResponse;
import com.turkcell.library_system.dto.author.ListAuthorResponse;
import com.turkcell.library_system.service.AuthorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    // CREATE
    @PostMapping
    public CreatedAuthorResponse add(@RequestBody CreateAuthorRequest request) {
        return authorService.add(request);
    }

    // GET ALL
    @GetMapping
    public List<ListAuthorResponse> getAll() {
        return authorService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ListAuthorResponse getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ListAuthorResponse update(@PathVariable Long id,
                                     @RequestBody UpdateAuthorRequest request) {
        return authorService.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
