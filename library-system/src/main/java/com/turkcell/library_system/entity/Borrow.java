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

    
}
