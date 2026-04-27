package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.reservation.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final ReservationStatusRepository statusRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  BookRepository bookRepository,
                                  StudentRepository studentRepository,
                                  ReservationStatusRepository statusRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.statusRepository = statusRepository;
    }

    public CreatedReservationResponse add(CreateReservationRequest request) {

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        ReservationStatus status = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setStudent(student);
        reservation.setStatus(status);
        reservation.setReservationDate(request.getReservationDate());

        Reservation saved = reservationRepository.save(reservation);

        CreatedReservationResponse response = new CreatedReservationResponse();
        response.setReservationId(saved.getReservationId());
        response.setBookId(book.getBookId());
        response.setStudentId(student.getStudentId());
        response.setStatusId(status.getStatusId());
        response.setReservationDate(saved.getReservationDate());

        return response;
    }

    public List<ListReservationResponse> getAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> {
                    ListReservationResponse response = new ListReservationResponse();
                    response.setReservationId(reservation.getReservationId());
                    response.setBookTitle(reservation.getBook().getTitle());
                    response.setStudentName(
                            reservation.getStudent().getFirstName() + " " +
                            reservation.getStudent().getLastName()
                    );
                    response.setStatus(reservation.getStatus().getStatusValue());
                    response.setReservationDate(reservation.getReservationDate());
                    return response;
                })
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}
