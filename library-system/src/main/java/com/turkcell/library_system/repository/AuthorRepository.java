package com.turkcell.library_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.library_system.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}