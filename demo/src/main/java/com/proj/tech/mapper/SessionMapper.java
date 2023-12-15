package com.proj.tech.mapper;

import com.proj.tech.dto.Session;
import com.proj.tech.model.SessionEntity;

public class SessionMapper {
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
