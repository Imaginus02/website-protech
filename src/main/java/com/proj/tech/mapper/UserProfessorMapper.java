package com.proj.tech.mapper;

import com.proj.tech.dto.User;
import com.proj.tech.dto.UserProfessor;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.UserEntity;
import com.proj.tech.model.UserProfessorEntity;

import java.util.stream.Collectors;

/**
 * Utility class for mapping UserProfessorEntity instances to UserProfessor instances.
 */
public class UserProfessorMapper {

    /**
     * Maps a UserProfessorEntity instance to a UserProfessor instance.
     *
     * @param user The UserProfessorEntity instance to be mapped.
     * @return A UserProfessor instance with essential details from the UserProfessorEntity.
     */
    public static UserProfessor of(UserProfessorEntity user) {
        return new UserProfessor(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUsername(),
                user.getActiveSessions().stream().map(SessionMapper::of).collect(Collectors.toList()),
                user.getArchivedSessions().stream().map(SessionMapper::of).collect(Collectors.toList()),
                user.getCodes().stream().map(CodeMapper::of).collect(Collectors.toList())
                );
    }
}
