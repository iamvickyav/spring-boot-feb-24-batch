package com.centralibrary.librarymanager.service;

import com.centralibrary.librarymanager.aop.TrackExecutionTime;
import com.centralibrary.librarymanager.dto.CreateStudentRequest;
import com.centralibrary.librarymanager.entity.Student;
import com.centralibrary.librarymanager.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Goal is to achieve Inversion of control. Its achieved using dependency injection (DI)
// Beans are managed by Spring context
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @TrackExecutionTime
    public void createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setDept(createStudentRequest.getDept());
        student.setName(createStudentRequest.getName());
        student.setEmailAddress(createStudentRequest.getEmailAddress());

        studentRepository.save(student);
    }
}
