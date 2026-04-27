package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.reservationStatus.*;
import com.turkcell.library_system.service.ReservationStatusServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation-status")
public class ReservationStatusController {

    private final ReservationStatusServiceImpl service;

    public ReservationStatusController(ReservationStatusServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CreatedReservationStatusResponse add(@RequestBody CreateReservationStatusRequest request) {
        return service.add(request);
    }

    @GetMapping
    public List<ListReservationStatusResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ListReservationStatusResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ListReservationStatusResponse update(@PathVariable Integer id,
                                                @RequestBody UpdateReservationStatusRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
