package com.gfi.academy.restfulservices.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gfi.academy.restfulservices.model.Employee;
import lombok.*;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NotNull
    @Min(value = 18, message = "Employee has to be 18 years or older!")
    private int age;

    @NotNull
    private String originCountry;

    @NotNull
    @Email
    private String email;

    @NotNull
    private boolean wantCommunication;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXX")
    private ZonedDateTime joinDate;

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXX")
    private ZonedDateTime expirationDate;

    public static EmployeeDTO from(Employee employee) {
        return EmployeeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .age(employee.getAge())
                .email(employee.getEmail())
                .wantCommunication(employee.isWantCommunication())
                .originCountry(employee.getOriginCountry())
                .joinDate(employee.getJoinDate())
                .expirationDate(employee.getExpirationDate())
                .build();
    }
}
