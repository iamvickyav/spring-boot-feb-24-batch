package com.centralibrary.librarymanager.repo;

import com.centralibrary.librarymanager.entity.Staff;
import com.centralibrary.librarymanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByEmailAddress(String emailAddress);
}
