package com.example.demo.domain.model;

import io.swagger.v3.oas.annotations.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest implements Serializable {

    @Hidden
    Integer id;
    String name;
    String avatarLink;
    @Hidden
    long countOfNotes;

}
