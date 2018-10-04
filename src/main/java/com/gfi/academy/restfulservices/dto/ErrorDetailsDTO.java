package com.gfi.academy.restfulservices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetailsDTO {

    private Date timestamp;
    private String message;

    public ErrorDetailsDTO(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
