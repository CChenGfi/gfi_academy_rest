package com.gfi.academy.restfulservices.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){
        super(String.format("Employee with id %s cannot be found!", id));
    }
}
