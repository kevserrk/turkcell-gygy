package com.turkcell.library_system.dto.book;

public class CreateBookRequest {

    private String title;
    private Integer publicationYear;
    private Integer copiesTotal;

    public String getTitle() {
        return title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Integer getCopiesTotal() {
        return copiesTotal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setCopiesTotal(Integer copiesTotal) {
        this.copiesTotal = copiesTotal;
    }
}