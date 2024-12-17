package com.example.rest_api.web_rest;

import com.example.rest_api.domain.Student;
import com.example.rest_api.dto.StudentDTO;
import com.example.rest_api.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDTO student){
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());
        studentService.studentAdd(student1);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // jwt toke generation api

}
