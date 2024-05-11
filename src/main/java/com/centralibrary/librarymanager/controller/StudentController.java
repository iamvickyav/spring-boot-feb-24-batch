package com.centralibrary.librarymanager.controller;

import com.centralibrary.librarymanager.dto.CreateStudentRequest;
import com.centralibrary.librarymanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    ResponseEntity<Void> createStudent(@RequestBody CreateStudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
        return ResponseEntity.status(200).build();
    }
}
