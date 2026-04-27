package com.turkcell.library_system.dto.reservation;

import java.time.LocalDate;

public class UpdateReservationRequest {

    private Integer statusId;
    private LocalDate reservationDate;

    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public LocalDate getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDate reservationDate) { this.reservationDate = reservationDate; }
}