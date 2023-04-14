package com.example.demo.domain.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Integer id) {
        super("Cannot find user by id = " + id);
    }
}
