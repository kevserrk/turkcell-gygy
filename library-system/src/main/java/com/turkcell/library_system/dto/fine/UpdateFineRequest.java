package com.turkcell.library_system.dto.fine;

import java.time.LocalDate;

public class UpdateFineRequest {

    private LocalDate fineDate;
    private Double fineAmount;

    public LocalDate getFineDate() {
        return fineDate;
    }

    public void setFineDate(LocalDate fineDate) {
        this.fineDate = fineDate;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }
}
