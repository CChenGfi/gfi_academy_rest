package com.gfi.academy.restfulservices.repository;

import com.gfi.academy.restfulservices.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findById(Long id);
}
