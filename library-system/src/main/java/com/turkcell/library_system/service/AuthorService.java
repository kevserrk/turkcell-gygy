package com.turkcell.library_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.author.*;
import com.turkcell.library_system.entity.Author;
import com.turkcell.library_system.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public CreatedAuthorResponse create(CreateAuthorRequest request) {

        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());

        author = authorRepository.save(author);

        CreatedAuthorResponse response = new CreatedAuthorResponse();
        response.setAuthorId(author.getAuthorId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());

        return response;
    }

    public List<ListAuthorResponse> getAll() {

        List<Author> authors = authorRepository.findAll();

        List<ListAuthorResponse> responseList = new ArrayList<>();

        for (Author author : authors) {
            ListAuthorResponse response = new ListAuthorResponse();
            response.setAuthorId(author.getAuthorId());
            response.setFirstName(author.getFirstName());
            response.setLastName(author.getLastName());
            responseList.add(response);
        }

        return responseList;
    }

    public ListAuthorResponse getById(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

        ListAuthorResponse response = new ListAuthorResponse();
        response.setAuthorId(author.getAuthorId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());

        return response;
    }

    public CreatedAuthorResponse update(UpdateAuthorRequest request, Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());

        author = authorRepository.save(author);

        CreatedAuthorResponse response = new CreatedAuthorResponse();
        response.setAuthorId(author.getAuthorId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());

        return response;
    }

    public void delete(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı"));

        authorRepository.delete(author);
    }
}