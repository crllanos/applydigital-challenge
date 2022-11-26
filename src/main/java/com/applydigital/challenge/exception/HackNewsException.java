package com.applydigital.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HackNewsException extends RuntimeException {

    private HttpStatus status;
    private String message;
    private Throwable e;

}
