package com.proj.tech.security.users;

import com.proj.tech.security.SpringSecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class StudentUser implements UserDetails {

    private String sessionId;
    // Other student-specific fields

    // Constructors, getters, and setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities/roles for the student user
        // For example, you might have a role called "ROLE_STUDENT"
        return List.of(new SimpleGrantedAuthority(SpringSecurityConfig.ROLE_STUDENT));
    }

    @Override
    public String getPassword() {
        // Students may not have passwords
        return null;
    }

    @Override
    public String getUsername() {
        // Students may use a session ID as their identifier
        return sessionId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Implement other UserDetails methods...
}

