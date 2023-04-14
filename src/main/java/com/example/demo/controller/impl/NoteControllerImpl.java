package com.example.demo.controller.impl;

import com.example.demo.controller.*;
import com.example.demo.domain.exception.*;
import com.example.demo.domain.model.*;
import com.example.demo.service.impl.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NoteControllerImpl implements NoteController {

    NoteService noteService;

    @Override
    public ResponseEntity<NoteDTO> createNewNote(NoteDTO note) throws UserNotFoundException {
        return ok(noteService.newNote(note));
    }

    @Override
    public ResponseEntity<NoteDTO> getNoteById(int id) throws NoteNotFoundException {
        return ok(noteService.findById(id));
    }
}
