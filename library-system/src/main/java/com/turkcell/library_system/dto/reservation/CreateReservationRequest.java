package com.turkcell.library_system.dto.reservation;

import java.time.LocalDate;

public class CreateReservationRequest {

    private Integer bookId;
    private Integer studentId;
    private Integer statusId;
    private LocalDate reservationDate;

    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public LocalDate getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDate reservationDate) { this.reservationDate = reservationDate; }
}
