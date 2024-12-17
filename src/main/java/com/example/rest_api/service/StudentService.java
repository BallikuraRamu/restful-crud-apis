package com.example.rest_api.service;

import com.example.rest_api.domain.Student;
import com.example.rest_api.repository.StudentRepo;

@org.springframework.stereotype.Service
public class StudentService {

    private final StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public String studentAdd(Student student){
        Student saved = studentRepo.save(student);
        return "Student added";
    }
}
