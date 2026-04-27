package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.borrow.*;
import com.turkcell.library_system.service.BorrowServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private final BorrowServiceImpl service;

    public BorrowController(BorrowServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedBorrowResponse add(@RequestBody CreateBorrowRequest request) {
        return service.add(request);
    }

    @GetMapping
    public List<ListBorrowResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}