package com.gfi.academy.restfulservices.controller;

import com.gfi.academy.restfulservices.dto.EmployeeDTO;
import com.gfi.academy.restfulservices.exception.EmployeeNotFoundException;
import com.gfi.academy.restfulservices.model.Employee;
import com.gfi.academy.restfulservices.repository.EmployeeRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<Employee> allEmployees = Lists.newArrayList(employeeRepository.findAll());
        List<EmployeeDTO> dtos = allEmployees.stream()
                .map(EmployeeDTO::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        EmployeeDTO dto = EmployeeDTO.from(employee);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> postEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        Employee employee = Employee.from(employeeDTO);
        employeeRepository.save(employee);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping(value = "/id")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean employeeExist = employeeRepository.existsById(id);
        if (!employeeExist)
            throw new EmployeeNotFoundException(id);
        employeeRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
