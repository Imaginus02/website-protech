package com.proj.tech.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "SP_USER")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "email")
    private String email;

    @OneToMany
    private Set<SessionEntity> activeSessions;

    @OneToMany
    private Set<SessionEntity> archivedSessions;

    @Column(nullable = false)
    private String password;

    @Column
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<SessionEntity> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Set<SessionEntity> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public Set<SessionEntity> getArchivedSessions() {
        return archivedSessions;
    }

    public void setArchivedSessions(Set<SessionEntity> archivedSessions) {
        this.archivedSessions = archivedSessions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
