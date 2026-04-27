package com.turkcell.library_system.controller;

import com.turkcell.library_system.dto.reservation.*;
import com.turkcell.library_system.service.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public CreatedReservationResponse add(@RequestBody CreateReservationRequest request) {
        return reservationService.add(request);
    }

    @GetMapping
    public List<ListReservationResponse> getAll() {
        return reservationService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }
}
