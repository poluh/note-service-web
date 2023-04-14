package com.example.demo.config;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.converter.*;
import org.springframework.context.annotation.*;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<User, UserRequest> userConverter(NoteRepository noteRepository) {
        return null;
    }

    @Bean
    public Converter<Note, NoteDTO> noteConverter(UserMapper converter) {
        return new Converter<>() {
            @Override
            public NoteDTO to(Note note) {
                return null;
            }

            @Override
            public Note from(NoteDTO noteDTO) {
                return null;
            }
        };
    }

}
