package com.turkcell.library_system.repository;

import com.turkcell.library_system.entity.LibraryStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {
}
