package com.centralibrary.librarymanager.repo;

import com.centralibrary.librarymanager.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, String> {

    Staff findByEmailAddress(String emailAddress);
}
