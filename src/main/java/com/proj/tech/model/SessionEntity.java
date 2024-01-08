package com.proj.tech.model;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * Entity class representing a session in the application.
 * A session is associated with a user and has various attributes such as name, status, password, etc.
 */
@Entity
@Table(name = "SP_SESSION")
public class SessionEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne(optional = false)
    private UserProfessorEntity user;

    @Column(nullable = false)
    private SessionStatus status;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Integer maxUser;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    /**
     * Gets the unique identifier for the session.
     *
     * @return The session's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the session.
     *
     * @param id The session's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the session.
     *
     * @return The session's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the session.
     *
     * @param name The session's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user associated with the session.
     *
     * @return The user associated with the session.
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Sets the user associated with the session.
     *
     * @param user The user associated with the session.
     */
    public void setUser(UserProfessorEntity user) {
        this.user = user;
    }

    /**
     * Gets the status of the session (ACTIVE or ARCHIVED).
     *
     * @return The status of the session.
     */
    public SessionStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the session (ACTIVE or ARCHIVED).
     *
     * @param status The status of the session.
     */
    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    /**
     * Gets the password associated with the session.
     *
     * @return The session's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password associated with the session.
     *
     * @param password The session's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the maximum number of users allowed in the session.
     *
     * @return The maximum number of users allowed in the session.
     */
    public Integer getMaxUser() {
        return maxUser;
    }

    /**
     * Sets the maximum number of users allowed in the session.
     *
     * @param maxUser The maximum number of users allowed in the session.
     */
    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    /**
     * Gets the start date of the session.
     *
     * @return The start date of the session.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the session.
     *
     * @param startDate The start date of the session.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the session.
     *
     * @return The end date of the session.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the session.
     *
     * @param endDate The end date of the session.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Default constructor for the SessionEntity class.
     */
    public SessionEntity() {
    }

    /**
     * Parameterized constructor for the SessionEntity class.
     *
     * @param id        The session's ID.
     * @param name      The session's name.
     * @param user      The user associated with the session.
     * @param status    The status of the session.
     * @param password  The session's password.
     * @param maxUser   The maximum number of users allowed in the session.
     * @param startDate The start date of the session.
     * @param endDate   The end date of the session.
     */
    public SessionEntity(Long id, String name, UserProfessorEntity user, SessionStatus status, String password, Integer maxUser, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.status = status;
        this.password = password;
        this.maxUser = maxUser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Constructor for creating a new active session with default values.
     *
     * @param name    The session's name.
     * @param user    The user associated with the session.
     * @param maxUser The maximum number of users allowed in the session.
     * @param endDate The end date of the session.
     */
    public SessionEntity(String name, UserProfessorEntity user, Integer maxUser, Date endDate) {
        this.name = name;
        this.user = user;
        this.maxUser = maxUser;
        this.endDate = endDate;
        this.status = SessionStatus.ACTIVE;
        this.startDate = Date.from(Instant.now());
        this.password = UUID.randomUUID().toString().substring(0, 6);
    }


}