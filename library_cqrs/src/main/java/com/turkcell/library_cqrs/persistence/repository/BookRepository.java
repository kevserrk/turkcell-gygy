package com.turkcell.library_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_cqrs.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}