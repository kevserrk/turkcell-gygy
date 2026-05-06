package com.turkcell.library_cqrs.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int studentId;

    private int bookId;

    private LocalDate borrowDate;

    public Borrow() {
    }

    public Borrow(int id, int studentId, int bookId, LocalDate borrowDate) {
        this.id = id;
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}
