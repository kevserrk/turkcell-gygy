package com.turkcell.library_system.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "return_book")
public class ReturnBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id")
    private Integer returnId;

    @OneToOne
    @JoinColumn(name = "borrow_id")
    private Borrow borrow;

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "received_by_staff_id")
    private LibraryStaff receivedBy;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LibraryStaff getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(LibraryStaff receivedBy) {
        this.receivedBy = receivedBy;
    }

   
}
