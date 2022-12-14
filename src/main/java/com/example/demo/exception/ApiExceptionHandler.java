package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import javax.naming.SizeLimitExceededException;
import javax.validation.ValidationException;
import java.net.BindException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> apiExceptionHandler(BadRequestException e) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                statusCode
        );
        return new ResponseEntity<>(apiException, statusCode);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> apiExceptionHandler(NotFoundException e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                statusCode
        );
        return new ResponseEntity<>(apiException, statusCode);
    }



}
