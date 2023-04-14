package com.example.demo.controller.impl;

import com.example.demo.controller.*;
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
public class UserControllerImpl implements UserController {

    UserService service;

    @Override
    public ResponseEntity<UserResponse> register(UserRequest user) {
        return ok(service.newUser(user));
    }
}
