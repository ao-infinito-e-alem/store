package com.example.store.usecase.exception.handler;

import com.example.store.adapter.repository.dto.ErrorDTO;
import com.example.store.usecase.exception.NotAcceptableException;
import com.example.store.usecase.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e, WebRequest request) {
        return handleExceptionInternal(e,
                new ErrorDTO("BUSINESS_ERROR", e.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity handleNotAcceptableException(NotAcceptableException e, WebRequest request) {
        return handleExceptionInternal(e,
                new ErrorDTO("BUSINESS_ERROR", e.getMessage()), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }
}