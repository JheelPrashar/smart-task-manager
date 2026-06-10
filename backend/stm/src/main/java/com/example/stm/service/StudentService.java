package com.example.stm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stm.model.Student;
import com.example.stm.repository.StudentRepository;

import org.springframework.jdbc.core.JdbcTemplate;
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
}
