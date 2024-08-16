package com.chasepacker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        System.out.println("******************************************************************************************");
        System.out.println("API Request Error:");
        System.out.println("Type mismatch error: Parameter name = " + ex.getName() + ", Parameter value = " + ex.getValue() + ", Message = " + ex.getMessage());
        System.out.println("******************************************************************************************");

        Map<String, String> response = new HashMap<>();
        response.put("error", "Invalid parameter type");
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        System.out.println("******************************************************************************************");
        System.out.println("API Request Error:");
        System.out.println("Validation error: Message = " + ex.getMessage());
        System.out.println("******************************************************************************************");

        Map<String, String> response = new HashMap<>();
        response.put("error", "Validation error");
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Add more exception handlers as needed
}