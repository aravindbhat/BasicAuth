package com.authorization.basicauth.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class ApiError {

    private String error;
    private LocalDateTime timestamp;
    private HttpStatus statusCode;

    public ApiError(String error, HttpStatus statusCode) {
        this.error = error;
        this.statusCode = statusCode;
    }
}
