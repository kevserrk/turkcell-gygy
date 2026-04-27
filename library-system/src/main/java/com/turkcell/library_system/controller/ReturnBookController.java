package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.returnBook.*;
import com.turkcell.library_system.service.ReturnBookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/returns")
public class ReturnBookController {

    private final ReturnBookServiceImpl service;

    public ReturnBookController(ReturnBookServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedReturnBookResponse add(@RequestBody CreateReturnBookRequest request) {
        return service.add(request);
    }

    @GetMapping
    public List<ListReturnBookResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}