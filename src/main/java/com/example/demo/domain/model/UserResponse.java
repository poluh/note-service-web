package com.example.demo.domain.model;

import lombok.*;
import lombok.experimental.*;

import java.io.*;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse implements Serializable {
    Integer id;
    String username;
    String avatarLink;
    long countOfNotes;
    long totalUsers;
}
