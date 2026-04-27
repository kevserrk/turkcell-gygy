package com.turkcell.library_system.repository;

import com.turkcell.library_system.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer> {
}