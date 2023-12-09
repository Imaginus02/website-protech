package com.proj.tech.dto;

import java.util.List;

public record UserProfessor(Long id, String email, String password, String username, List<Session> activeSession, List<Session> archivedSession) {
}