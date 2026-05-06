package com.turkcell.library_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_cqrs.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}