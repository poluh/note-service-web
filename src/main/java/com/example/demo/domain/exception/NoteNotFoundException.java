package com.example.demo.domain.exception;

public class NoteNotFoundException extends NotFoundException {

    public NoteNotFoundException(Integer id) {
        super("Note with id " + id + " not found ");
    }
}
