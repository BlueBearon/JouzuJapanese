package com.chasepacker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
       return new ResponseEntity<>("Missing required request parameter", HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
   public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
       return new ResponseEntity<>("Invalid data type", HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> handleAll(Exception ex) {
       return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
   }
}