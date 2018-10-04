package com.gfi.academy.restfulservices.model;

import com.gfi.academy.restfulservices.dto.EmployeeDTO;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "want_communication")
    private boolean wantCommunication;

    @Column(name = "join_date")
    private ZonedDateTime joinDate;

    @Column(name = "expiration_date")
    private ZonedDateTime expirationDate;

    public static Employee from(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .age(employeeDTO.getAge())
                .email(employeeDTO.getEmail())
                .originCountry(employeeDTO.getOriginCountry())
                .wantCommunication(employeeDTO.isWantCommunication())
                .joinDate(employeeDTO.getJoinDate())
                .expirationDate(employeeDTO.getExpirationDate())
                .build();
    }

    public Employee update(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.age = employeeDTO.getAge();
        this.email = employeeDTO.getEmail();
        this.wantCommunication = employeeDTO.isWantCommunication();
        this.originCountry = employeeDTO.getOriginCountry();
        this.joinDate = employeeDTO.getJoinDate();
        this.expirationDate = employeeDTO.getExpirationDate();
        return this;
    }
}
