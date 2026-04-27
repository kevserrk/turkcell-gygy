package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.reservationStatus.*;
import com.turkcell.library_system.entity.ReservationStatus;
import com.turkcell.library_system.repository.ReservationStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationStatusServiceImpl {

    private final ReservationStatusRepository repository;

    public ReservationStatusServiceImpl(ReservationStatusRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public CreatedReservationStatusResponse add(CreateReservationStatusRequest request) {
        ReservationStatus status = new ReservationStatus();
        status.setStatusValue(request.getStatusValue());

        ReservationStatus saved = repository.save(status);

        CreatedReservationStatusResponse response = new CreatedReservationStatusResponse();
        response.setStatusId(saved.getStatusId());
        response.setStatusValue(saved.getStatusValue());

        return response;
    }

    // GET ALL
    public List<ListReservationStatusResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(status -> {
                    ListReservationStatusResponse response = new ListReservationStatusResponse();
                    response.setStatusId(status.getStatusId());
                    response.setStatusValue(status.getStatusValue());
                    return response;
                })
                .collect(Collectors.toList());
    }

    // GET BY ID
    public ListReservationStatusResponse getById(Integer id) {
        ReservationStatus status = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        ListReservationStatusResponse response = new ListReservationStatusResponse();
        response.setStatusId(status.getStatusId());
        response.setStatusValue(status.getStatusValue());

        return response;
    }

    // UPDATE
    public ListReservationStatusResponse update(Integer id, UpdateReservationStatusRequest request) {
        ReservationStatus status = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        status.setStatusValue(request.getStatusValue());

        ReservationStatus updated = repository.save(status);

        ListReservationStatusResponse response = new ListReservationStatusResponse();
        response.setStatusId(updated.getStatusId());
        response.setStatusValue(updated.getStatusValue());

        return response;
    }

    // DELETE
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
