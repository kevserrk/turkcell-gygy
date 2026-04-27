package com.turkcell.library_system.service;

import com.turkcell.library_system.dto.libraryStaff.*;
import com.turkcell.library_system.entity.LibraryStaff;
import com.turkcell.library_system.repository.LibraryStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryStaffServiceImpl {

    private final LibraryStaffRepository repository;

    public LibraryStaffServiceImpl(LibraryStaffRepository repository) {
        this.repository = repository;
    }

    public CreatedLibraryStaffResponse add(CreateLibraryStaffRequest request) {

        LibraryStaff staff = new LibraryStaff();
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());

        LibraryStaff saved = repository.save(staff);

        CreatedLibraryStaffResponse response = new CreatedLibraryStaffResponse();
        response.setStaffId(saved.getStaffId());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());

        return response;
    }

    public List<ListLibraryStaffResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(staff -> {
                    ListLibraryStaffResponse response = new ListLibraryStaffResponse();
                    response.setStaffId(staff.getStaffId());
                    response.setFirstName(staff.getFirstName());
                    response.setLastName(staff.getLastName());
                    return response;
                })
                .collect(Collectors.toList());
    }

    public ListLibraryStaffResponse getById(Integer id) {
        LibraryStaff staff = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        ListLibraryStaffResponse response = new ListLibraryStaffResponse();
        response.setStaffId(staff.getStaffId());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());

        return response;
    }

    public ListLibraryStaffResponse update(Integer id, UpdateLibraryStaffRequest request) {
        LibraryStaff staff = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());

        LibraryStaff updated = repository.save(staff);

        ListLibraryStaffResponse response = new ListLibraryStaffResponse();
        response.setStaffId(updated.getStaffId());
        response.setFirstName(updated.getFirstName());
        response.setLastName(updated.getLastName());

        return response;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
