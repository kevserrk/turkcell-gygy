package com.turkcell.library_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "copies_total")
    private Integer copiesTotal;

    // Getter Setter
    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getPublicationYear() { return publicationYear; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }

    public Integer getCopiesTotal() { return copiesTotal; }
    public void setCopiesTotal(Integer copiesTotal) { this.copiesTotal = copiesTotal; }
}