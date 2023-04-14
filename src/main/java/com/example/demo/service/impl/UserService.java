package com.example.demo.service.impl;

import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.converter.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository repository;
    UserMapper converter;

    public UserResponse newUser(UserRequest dto) {
        System.out.println("DTO " + dto);
        val user = converter.toEntity(dto);
        val saved = repository.save(user);
        return converter.toResponse(saved);
    }

    public boolean exists(int userId) {
        return repository.existsById(userId);
    }

    public UserRequest edit(int id, UserRequest dto) {
        val original = repository.findById(id)
                .orElse(null);
        if (original == null) {
            return null;
        }

        val user = converter.toEntity(dto);
        val merged = Converter.merge(original, user);
        merged.setId(id);
        val result = repository.save(merged);
        return converter.toDTO(result);
    }

}
