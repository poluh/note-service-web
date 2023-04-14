package com.example.demo.service.converter;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import lombok.*;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.*;

@Setter
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected NoteRepository noteRepository;

    @Mapping(target = "username", source = "name")
    @Mapping(target = "countOfNotes", expression = "java(noteRepository.getCountByAuthorId(entity.getId()))")
    @Mapping(target = "totalUsers", expression = "java(userRepository.count())")
    public abstract UserResponse toResponse(User entity);

    @Mapping(target = "countOfNotes", expression = "java(userRepository.count())")
    public abstract UserRequest toDTO(User user);

    @Mapping(target = "name", source = "username")
    public abstract UserRequest fromResponse(UserResponse response);

    public abstract User toEntity(UserRequest user);

}
