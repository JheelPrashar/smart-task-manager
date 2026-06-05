package com.example.stm.controller;
import com.example.stm.model.Student;


import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {
    
    @GetMapping
    public ArrayList<Student> getStudent(){
        ArrayList<Student>students=new ArrayList<>();
        students.add(
                new Student(1, "Tushar", "Bca")
        );

        students.add(
                new Student(2, "Rahul", "Bca")
        );

        students.add(
                new Student(3, "Aman", "Mca")
        );

        return students;
    }
    @GetMapping("/bca")
    public List<Student> getBcaStudent(){
        return getStudent().stream()
        .filter(student -> "Bca".equals(student.getCourse()))
        .collect(Collectors.toList());
    }
    
}

