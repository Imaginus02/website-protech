package com.proj.tech.dto;

import com.proj.tech.dto.blocks.Code;

import java.util.List;

public record UserProfessor(Long id, String email, String password, String username, List<Session> activeSession, List<Session> archivedSession, List<Code> codes) {
}