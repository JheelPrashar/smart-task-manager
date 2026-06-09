package com.example.stm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class StudentService {
    public String getStudentInfo(){
        return" Service is working";
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

   public Integer getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql,Integer.class);

    }
}
