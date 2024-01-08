package com.proj.tech.dto;

import com.proj.tech.dto.blocks.Code;

import java.util.List;

/**
 * A record representing a professor user in the system.
 *
 * <p>
 * This record includes information such as the professor's unique identifier, email, password, username,
 * and lists of active sessions, archived sessions, and codes associated with the professor.
 * </p>
 *
 * <p>
 * Note: This record is designed for immutability and is suitable for use in scenarios where the data is read-only.
 * </p>
 *
 * @param id              The unique identifier of the professor user.
 * @param email           The email address of the professor user.
 * @param password        The password associated with the professor user.
 * @param username        The username of the professor user.
 * @param activeSession   The list of active sessions associated with the professor.
 * @param archivedSession The list of archived sessions associated with the professor.
 * @param codes           The list of codes associated with the professor.
 */
public record UserProfessor(Long id, String email, String password, String username, List<Session> activeSession, List<Session> archivedSession, List<Code> codes) {
}