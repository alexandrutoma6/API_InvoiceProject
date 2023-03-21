package com.alex.controller;

import com.alex.exceptions.NotFoundException;
import com.alex.exceptions.ValidationException;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class InvoiceExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(InvoiceExceptionAdvice.class);


    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleNotFoundException(NotFoundException ex) {
        log.error("Received error {}", ex.getMessage());
        return ErrorResponse.builder(ex, BAD_REQUEST, ex.getMessage())
                .build();
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleValidationException(ValidationException ex) {
        log.error("Received error {}", ex.getMessage());
        return ErrorResponse.builder(ex, BAD_REQUEST, ex.getMessage())
                .build();
    }
}
