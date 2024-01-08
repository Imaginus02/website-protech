package com.proj.tech.dto;

/**
 * A record representing a command to update the information of a professor user in the system.
 *
 * <p>
 * This record is used when a professor user sends a POST request to update their email, username, or password.
 * Only one of the three arguments (email, username, password) should be provided in a single command.
 * </p>
 *
 * <p>
 * Note: This record is designed to be used specifically for processing user update commands.
 * </p>
 *
 * @param email    The new email to be set for the professor user (or null if not provided for update).
 * @param username The new username to be set for the professor user (or null if not provided for update).
 * @param password The new password to be set for the professor user (or null if not provided for update).
 */
public record UserProfessorCommand(String email, String username, String password) {
}
