package com.example.demo.service.impl;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.exception.*;
import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.util.*;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NoteService {

    NoteRepository repository;
    UserRepository userRepository;
    Converter<Note, NoteDTO> converter;

    public NoteDTO newNote(NoteDTO dto) throws UserNotFoundException {
        val note = converter.from(dto);
        val result = userRepository.findById(dto.getAuthor().getId())
                .map(a -> {
                    note.setAuthor(a);
                    return repository.save(note);
                })
                .orElseThrow(() -> new UserNotFoundException(dto.getAuthor().getId()));
        return converter.to(result);
    }

    public boolean isAuthor(int id, int userId) {
        return repository.isAuthor(userId, id);
    }

    public NoteDTO edit(int id, int authorId, NoteDTO edited) throws UserNotFoundException {
        val original = repository.findById(id)
                .map(converter::to)
                .orElse(null);
        if (original == null) {
            return null;
        }

        val author = userRepository.findById(authorId)
                .orElseThrow(() -> new UserNotFoundException(authorId));

        val merged = Converter.merge(original, edited);
        val note = converter.from(merged);
        note.setId(id);
        note.setEditedDateTime(Instant.now().getEpochSecond());
        note.setAuthor(author);

        val result = repository.save(note);

        return converter.to(result);
    }

    @Transactional
    public void test() {
        getByAuthorId(12);
    }

    @Transactional
    public Collection<NoteDTO> getByAuthorId(int authorId) {
        return repository.getAllByAuthorId(authorId)
                .parallelStream()
                .map(converter::to)
                .collect(toList());
    }

    public boolean deleteNote(int userId, int noteId) {
        if (!repository.isAuthor(userId, noteId)) {
            return false;
        }
        repository.deleteById(noteId);
        return true;
    }

    public NoteDTO findById(int id) throws NoteNotFoundException {

        return repository.findById(id)
                .map(converter::to)
                .orElseThrow(() -> new NoteNotFoundException(id));

    }
}
