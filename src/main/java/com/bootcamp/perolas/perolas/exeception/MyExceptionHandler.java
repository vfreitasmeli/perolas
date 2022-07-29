package com.bootcamp.perolas.perolas.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFound(NotFoundException exception) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                    .title(exception.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequest(BadRequestException exception) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

}
