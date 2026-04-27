package com.turkcell.library_system.repository;

import com.turkcell.library_system.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}