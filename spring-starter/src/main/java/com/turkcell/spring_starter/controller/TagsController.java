package com.turkcell.spring_starter.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.spring_starter.dto.CreateTagRequest;
import com.turkcell.spring_starter.dto.CreatedTagResponse;
import com.turkcell.spring_starter.dto.ListTagResponse;
import com.turkcell.spring_starter.dto.UpdateTagRequest;
import com.turkcell.spring_starter.service.TagServiceImpl;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

    private final TagServiceImpl tagServiceImpl;

    public TagsController(TagServiceImpl tagServiceImpl) {
        this.tagServiceImpl = tagServiceImpl;
    }

    @PostMapping
    public CreatedTagResponse create(@RequestBody CreateTagRequest request) {
        return tagServiceImpl.create(request);
    }

    @GetMapping
    public List<ListTagResponse> getAll() {
        return tagServiceImpl.getAll();
    }

    @GetMapping("{id}")
    public ListTagResponse getById(@PathVariable UUID id) {
        return tagServiceImpl.getById(id);
    }

    @PutMapping
    public CreatedTagResponse update(@RequestBody UpdateTagRequest request) {
        return tagServiceImpl.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        tagServiceImpl.delete(id);
    }
}
