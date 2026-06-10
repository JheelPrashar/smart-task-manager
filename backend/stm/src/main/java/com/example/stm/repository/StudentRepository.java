package com.example.stm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stm.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    
}
