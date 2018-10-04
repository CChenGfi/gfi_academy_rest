package com.gfi.academy.restfulservices.controller;

import com.gfi.academy.restfulservices.dto.ErrorDetailsDTO;
import com.gfi.academy.restfulservices.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> resourceNotFound(EmployeeNotFoundException ex) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailsDTO> handle(MethodArgumentNotValidException ex) {
        String errorMsg = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> "field '" + fieldError.getField() + "': " + fieldError.getDefaultMessage())
                .findFirst()
                .orElse(ex.getMessage());
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), errorMsg);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
