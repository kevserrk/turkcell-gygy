package com.turkcell.library_system.repository;

import com.turkcell.library_system.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {
}