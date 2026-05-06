package com.turkcell.library_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_cqrs.domain.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}
