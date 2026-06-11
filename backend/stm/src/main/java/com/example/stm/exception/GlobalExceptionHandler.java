package com.example.stm.exception;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(StudentNotFindException.class)
   public ResponseEntity<?> handleStudentNotFound(StudentNotFindException ex) {

        return ResponseEntity
                .badRequest()
                .body(Map.of ("message", ex.getMessage()));
   }
}

