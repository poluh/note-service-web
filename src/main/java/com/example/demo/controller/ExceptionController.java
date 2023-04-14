package com.example.demo.controller;

import com.example.demo.domain.exception.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.stream.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.*;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<?> notFoundExceptionHandler(UserNotFoundException ex) {
        return status(NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> allException(Exception ex) {
        val exTrace = new StringBuilder();
        Stream.of(ex.getStackTrace())
                .forEach(s -> exTrace.append("\n").append(s));
        return status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage() + "\n" + exTrace);
    }

}
