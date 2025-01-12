package com.kbtg.bootcamp.posttest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                notFoundException.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DuplicateException.class})
    public ResponseEntity<Object> handleDuplicateException(DuplicateException duplicateException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                duplicateException.getMessage(),
                HttpStatus.CREATED
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.CREATED);
    }

    @ExceptionHandler(value = {DeletionFailedException.class})
    public ResponseEntity<Object> handleDeletionFailedException(DeletionFailedException deletionFailedException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                deletionFailedException.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.CREATED);
    }
}


