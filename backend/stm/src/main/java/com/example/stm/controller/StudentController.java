package com.example.stm.controller;
import com.example.stm.model.Student;


import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {
    @GetMapping
    public Student getStudent(){
        return new Student(1, "jheel", "jheelprashar@gmail.com");
    }
}

