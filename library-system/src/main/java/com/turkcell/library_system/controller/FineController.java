package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.fine.*;
import com.turkcell.library_system.service.FineServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    private final FineServiceImpl service;

    public FineController(FineServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedFineResponse add(@RequestBody CreateFineRequest request) {
        return service.add(request);
    }

    @GetMapping
    public List<ListFineResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}