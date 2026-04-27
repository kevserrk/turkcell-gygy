package com.turkcell.library_system.dto.book;

import java.util.List;

public class CreateBookRequest {

    private String title;
    private Integer publicationYear;
    private Integer copiesTotal;

    private List<Long> authorIds;

    public String getTitle() { return title; }
    public Integer getPublicationYear() { return publicationYear; }
    public Integer getCopiesTotal() { return copiesTotal; }
    public List<Long> getAuthorIds() { return authorIds; }

    public void setTitle(String title) { this.title = title; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }
    public void setCopiesTotal(Integer copiesTotal) { this.copiesTotal = copiesTotal; }
    public void setAuthorIds(List<Long> authorIds) { this.authorIds = authorIds; }
}