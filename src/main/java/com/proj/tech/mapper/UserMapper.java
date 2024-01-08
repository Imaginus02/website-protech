package com.proj.tech.mapper;

import com.proj.tech.dto.User;
import com.proj.tech.model.UserEntity;

import java.util.stream.Collectors;

/**
 * Utility class for mapping UserEntity instances to User instances.
 */
public class UserMapper {

    /**
     * Maps a UserEntity instance to a User instance.
     *
     * @param user The UserEntity instance to be mapped.
     * @return A User instance with essential details from the UserEntity.
     */
    public static User of(UserEntity user) {
        return new User(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUsername()
        );
    }
}
