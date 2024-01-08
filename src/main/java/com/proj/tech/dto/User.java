package com.proj.tech.dto;

/**
 * A record representing a user in the system.
 *
 * <p>
 * This record includes information such as the user's unique identifier, email, password and username.
 * </p>
 *
 * <p>
 * Note: This record is designed for immutability and is suitable for use in scenarios where the data is read-only.
 * </p>
 *
 * @param id        The unique identifier of the user.
 * @param email     The email of the user.
 * @param password  The password of the user
 * @param username  The username of the user
 */
public record User(Long id, String email, String password, String username) {
}
