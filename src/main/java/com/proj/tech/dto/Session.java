package com.proj.tech.dto;

import com.proj.tech.model.SessionStatus;

import java.util.Date;

/**
 * A record representing a session in the system.
 *
 * <p>
 * This record includes information such as the session's unique identifier, name, user ID, status, password,
 * maximum number of users, start date, and end date.
 * </p>
 *
 * <p>
 * Note: This record is designed for immutability and is suitable for use in scenarios where the data is read-only.
 * </p>
 *
 * @param id        The unique identifier of the session.
 * @param name      The name of the session.
 * @param userId    The user ID associated with the session.
 * @param status    The status of the session, indicating whether it is active or archived.
 * @param password  The password associated with the session.
 * @param nombreMax The maximum number of users allowed in the session.
 * @param startDate The start date of the session.
 * @param endDate   The end date of the session.
 */
public record Session(Long id, String name, Long userId, SessionStatus status, String password, Integer nombreMax, Date startDate, Date endDate) {
}
