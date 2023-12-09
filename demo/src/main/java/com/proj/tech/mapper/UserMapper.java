package com.proj.tech.mapper;

import com.proj.tech.dto.User;
import com.proj.tech.model.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {
    public static User of(UserEntity user) {
        return new User(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUsername()
        );
    }
}
