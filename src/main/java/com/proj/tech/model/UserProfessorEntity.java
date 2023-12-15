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

    @Override
    public Long getId() {
        return id;
    }

    public Set<CodeEntity> getCodes() {
        return this.codes;
    }

    public void setCodes(Set<CodeEntity> codes) {
        this.codes = codes;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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


    public UserProfessorEntity() {
        super();
    }

    public UserProfessorEntity(String email, String username, String password) {
        super(email, username, password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities/roles for the teacher user
        // For example, you might have a role called "ROLE_TEACHER"
        // You can use SimpleGrantedAuthority for simplicity
        // You might have more complex logic based on your application's roles and permissions
        return List.of(new SimpleGrantedAuthority(SpringSecurityConfig.ROLE_PROFESSOR));
    }
}
