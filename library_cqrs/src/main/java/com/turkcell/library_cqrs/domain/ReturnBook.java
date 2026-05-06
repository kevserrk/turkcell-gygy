package com.turkcell.library_cqrs.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "returned_books")
public class ReturnBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int borrowId;

    private LocalDate returnDate;

    public ReturnBook() {
    }

    public ReturnBook(int id, int borrowId, LocalDate returnDate) {
        this.id = id;
        this.borrowId = borrowId;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}