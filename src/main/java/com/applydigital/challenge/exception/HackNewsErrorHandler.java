package com.applydigital.challenge.exception;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<HackNewsException> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(HackNewsException.builder()
                                                    .status(HttpStatus.BAD_REQUEST)
                                                    .message(e.getMessage())
                                                .build());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<HackNewsException> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(HackNewsException.builder()
                                                    .status(HttpStatus.BAD_REQUEST)
                                                    .message(e.getMessage())
                                                .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HackNewsException> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(HackNewsException.builder()
                                        .status(HttpStatus.NOT_FOUND)
                                        .message(e.getMessage())
                                    .build());
    }

}
