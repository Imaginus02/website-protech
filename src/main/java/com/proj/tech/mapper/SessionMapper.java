package com.proj.tech.mapper;

import com.proj.tech.dto.Session;
import com.proj.tech.model.SessionEntity;

/**
 * Utility class for mapping SessionEntity instances to Session instances.
 */
public class SessionMapper {

    /**
     * Maps a SessionEntity instance to a Session instance.
     *
     * @param session The SessionEntity instance to be mapped.
     * @return A Session instance with essential details from the SessionEntity.
     */
    public static Session of(SessionEntity session) {
        return new Session(
            session.getId(),
            session.getName(),
            session.getUser().getId(),
            session.getStatus(),
            session.getPassword(),
            session.getMaxUser(),
            session.getStartDate(),
            session.getEndDate()
        );
    }
}
