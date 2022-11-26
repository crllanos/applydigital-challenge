package com.applydigital.challenge.exception;

import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class HackNewsErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Exception> handleConstraintViolationException(ConstraintViolationException e) {
        // @todo adds full stacktrace, not sure why. weird.
        return ResponseEntity.badRequest().body(HackNewsException.builder()
                                                    .status(HttpStatus.BAD_REQUEST)
                                                    .message(e.getMessage())
                                                .build());
    }

}
