package com.example.demo.domain.model;

import io.swagger.v3.oas.annotations.*;
import lombok.*;
import lombok.experimental.*;

import java.io.*;
import java.time.*;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NoteDTO implements Serializable {

    Integer id;
    String text;
    @Hidden
    UserRequest author;
    LocalDateTime createdDateTime;
    @Hidden
    LocalDateTime editedDateTime;

}
