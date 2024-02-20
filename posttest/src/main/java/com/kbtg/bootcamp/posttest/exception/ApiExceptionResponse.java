package com.kbtg.bootcamp.posttest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class ApiExceptionResponse {
    private final String message;
    private final HttpStatus httpStatus;

    public ApiExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

