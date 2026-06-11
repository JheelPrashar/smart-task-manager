package com.example.stm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stm.model.Student;
import com.example.stm.repository.StudentRepository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.stm.dto.StudentRequestDTO;
import com.example.stm.exception.StudentNotFindException;

@Service
public class StudentService {
    public String getStudentInfo(){
        return" Service is working";
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRepository repository;

   public Integer getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql,Integer.class);

    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public Student getStudentById(Integer id){
        return repository
        .findById(id)
        .orElseThrow(()-> new StudentNotFindException("Student not found with id: "+id));
    }

    public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
}
}
