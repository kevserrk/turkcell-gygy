package com.turkcell.library_system.repository;

import com.turkcell.library_system.entity.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnBookRepository extends JpaRepository<ReturnBook, Integer> {
}
