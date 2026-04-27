package com.turkcell.library_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow")

public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer borrowId;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Student student;

    private LocalDate borrowDate;

    @ManyToOne
    @JoinColumn(name = "issued_by_staff_id")
    private LibraryStaff issuedBy;

    

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LibraryStaff getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(LibraryStaff issuedBy) {
        this.issuedBy = issuedBy;
    }
}
