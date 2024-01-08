package com.proj.tech.model;

/**
 * Enumeration representing the status of a session.
 * The two possible values are ACTIVE and ARCHIVED.
 */
public enum SessionStatus {
    /**
     * Indicates that the session is active, meaning its end date has not yet passed.
     */
    ACTIVE,

    /**
     * Indicates that the session is archived, meaning its end date has passed.
     */
    ARCHIVED
}