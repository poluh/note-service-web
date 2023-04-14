package com.example.demo.domain.exception;

public abstract class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
