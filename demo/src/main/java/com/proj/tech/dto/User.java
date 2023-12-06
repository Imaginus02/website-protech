package com.proj.tech.dto;

import com.proj.tech.dto.Session;

import java.util.List;
import java.util.Set;

public record User(Long id, String email, String password, String username, List<Session> activeSession, List<Session> archivedSession) {
}
