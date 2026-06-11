package com.example.stm.controller;
import com.example.stm.dto.StudentRequestDTO;
import com.example.stm.dto.StudentResponseDTO;
import com.example.stm.model.Student;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stm.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {
    
    @Autowired
    private StudentService service;
    
    // @GetMapping
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
    
    @GetMapping("/count")
    public int countStudents(){
        return service.getStudentCount();
    }

    @GetMapping("/message")
    public String getMessage(){
        return service.getStudentInfo();
    }
    @GetMapping
    public List<Student>getStudents(){
        return service.getAllStudents();
    }
    // @PostMapping
    //  public Student addStudent(@RequestBody Student student){
    //     return service.saveStudent(student);
    //  }

     @GetMapping("/{id}")
     public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        Student student=service.getStudentById(id);
        StudentResponseDTO response=new StudentResponseDTO(
            student.getId(),
            student.getName(),
            student.getCourse()
     );
     return ResponseEntity.ok(response);
     }

     @PostMapping
     public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto){
        Student student= service.addStudent(dto);
        return ResponseEntity.ok(student);
     }

}

