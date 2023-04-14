package com.example.demo.controller;

import com.example.demo.domain.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {

    @PostMapping
    ResponseEntity<UserResponse> register(@RequestBody UserRequest user);

}
