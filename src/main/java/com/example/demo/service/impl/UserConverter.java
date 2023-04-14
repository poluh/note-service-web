package com.example.demo.service.impl;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.model.UserRequest;
import com.example.demo.service.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserConverter extends Converter<User, UserRequest> {

    Function<Integer, Integer> getCountOfNotes;


    @Override
    public UserRequest to(User user) {
        if (user == null) {
            return null;
        }

        return UserRequest.builder()
                .id(user.getId())
                .name(user.getName())
                .avatarLink(user.getAvatarLink())
                .countOfNotes(getCountOfNotes.apply(user.getId()))
                .build();
    }

    @Override
    public User from(UserRequest userDTO) {

        if (userDTO == null) {
            return null;
        }

        val user = new User();
        BeanUtils.copyProperties(userDTO, user, "countOfNotes", "id");
        return user;
    }
}
