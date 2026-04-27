package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.author.CreateAuthorRequest;
import com.turkcell.library_system.dto.author.UpdateAuthorRequest;
import com.turkcell.library_system.dto.author.CreatedAuthorResponse;
import com.turkcell.library_system.dto.author.ListAuthorResponse;
import com.turkcell.library_system.entity.Author;
import com.turkcell.library_system.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //  CREATE
    public CreatedAuthorResponse add(CreateAuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());

        Author saved = authorRepository.save(author);

        CreatedAuthorResponse response = new CreatedAuthorResponse();
        response.setAuthorId(saved.getAuthorId());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());

        return response;
    }

    //  GET ALL
    public List<ListAuthorResponse> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> {
                    ListAuthorResponse response = new ListAuthorResponse();
                    response.setAuthorId(author.getAuthorId());
                    response.setFirstName(author.getFirstName());
                    response.setLastName(author.getLastName());
                    return response;
                })
                .collect(Collectors.toList());
    }

    // GET BY ID
    public ListAuthorResponse getById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        ListAuthorResponse response = new ListAuthorResponse();
        response.setAuthorId(author.getAuthorId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());

        return response;
    }

    // UPDATE
    public ListAuthorResponse update(Long id, UpdateAuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());

        Author updated = authorRepository.save(author);

        ListAuthorResponse response = new ListAuthorResponse();
        response.setAuthorId(updated.getAuthorId());
        response.setFirstName(updated.getFirstName());
        response.setLastName(updated.getLastName());

        return response;
    }

    // DELETE
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}