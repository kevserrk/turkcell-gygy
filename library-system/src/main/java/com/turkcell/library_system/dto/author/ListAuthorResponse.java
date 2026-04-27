package com.turkcell.library_system.dto.author;

public class ListAuthorResponse {

    private Long authorId;
    private String firstName;
    private String lastName;

    public Long getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
