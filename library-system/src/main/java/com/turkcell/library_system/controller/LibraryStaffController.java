package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.libraryStaff.*;
import com.turkcell.library_system.service.LibraryStaffServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class LibraryStaffController {

    private final LibraryStaffServiceImpl service;

    public LibraryStaffController(LibraryStaffServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedLibraryStaffResponse add(@RequestBody CreateLibraryStaffRequest request) {
        return service.add(request);
    }

    @GetMapping
    public List<ListLibraryStaffResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ListLibraryStaffResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ListLibraryStaffResponse update(@PathVariable Integer id,
                                           @RequestBody UpdateLibraryStaffRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}