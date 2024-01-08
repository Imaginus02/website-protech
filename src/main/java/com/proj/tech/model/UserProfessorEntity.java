package com.proj.tech.model;

import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.security.SpringSecurityConfig;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Represents a professor user entity in the application, extending the UserEntity class.
 */
@Entity
@Table(name = "SP_USER_PROFESSOR")
public class UserProfessorEntity extends UserEntity {//implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<SessionEntity> activeSessions;

    @OneToMany
    private Set<SessionEntity> archivedSessions;

    @OneToMany(mappedBy = "creator")
    private Set<CodeEntity> codes;

    /**
     * Gets the unique identifier for the professor user.
     *
     * @return The professor user's ID.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the professor user.
     *
     * @param id The professor user's ID.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the set of active sessions associated with the professor user.
     *
     * @return The set of active sessions.
     */
    public Set<SessionEntity> getActiveSessions() {
        return activeSessions;
    }

    /**
     * Sets the set of active sessions associated with the professor user.
     *
     * @param activeSessions The set of active sessions.
     */
    public void setActiveSessions(Set<SessionEntity> activeSessions) {
        this.activeSessions = activeSessions;
    }

    /**
     * Gets the set of archived sessions associated with the professor user.
     *
     * @return The set of archived sessions.
     */
    public Set<SessionEntity> getArchivedSessions() {
        return archivedSessions;
    }

    /**
     * Sets the set of archived sessions associated with the professor user.
     *
     * @param archivedSessions The set of archived sessions.
     */
    public void setArchivedSessions(Set<SessionEntity> archivedSessions) {
        this.archivedSessions = archivedSessions;
    }

    /**
     * Gets the set of codes associated with the professor user.
     *
     * @return The set of codes.
     */
    public Set<CodeEntity> getCodes() {
        return this.codes;
    }

    /**
     * Sets the set of codes associated with the professor user.
     *
     * @param codes The set of codes.
     */
    public void setCodes(Set<CodeEntity> codes) {
        this.codes = codes;
    }

    /**
     * Default constructor for the UserProfessorEntity class.
     */
    public UserProfessorEntity() {
        super();
    }

    /**
     * Parameterized constructor for the UserProfessorEntity class.
     *
     * @param email    The professor user's email.
     * @param username The professor user's username.
     * @param password The professor user's password.
     */
    public UserProfessorEntity(String email, String username, String password) {
        super(email, username, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities/roles for the teacher user
        // For example, you might have a role called "ROLE_TEACHER"
        // You can use SimpleGrantedAuthority for simplicity
        // You might have more complex logic based on your application's roles and permissions
        return List.of(new SimpleGrantedAuthority(SpringSecurityConfig.ROLE_PROFESSOR));
    }
}
