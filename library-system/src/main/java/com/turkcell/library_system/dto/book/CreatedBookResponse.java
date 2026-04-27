package com.turkcell.library_system.dto.book;

public class CreatedBookResponse {

    private Integer bookId;
    private String title;
    private Integer publicationYear;
    private Integer copiesTotal;

    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getPublicationYear() { return publicationYear; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }

    public Integer getCopiesTotal() { return copiesTotal; }
    public void setCopiesTotal(Integer copiesTotal) { this.copiesTotal = copiesTotal; }
}