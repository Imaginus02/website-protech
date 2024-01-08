package com.proj.tech.model;

import com.proj.tech.security.SpringSecurityConfig;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * An abstract class representing a user entity in the application.
 * This class implements the UserDetails interface, providing necessary information for Spring Security.
 */
@MappedSuperclass
public abstract class UserEntity implements UserDetails {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * The email address of the user.
     */
    @Column(nullable = false, name = "email")
    private String email;

    /**
     * The password of the user.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The username of the user.
     */
    @Column
    private String username;

    /**
     * Default constructor for the UserEntity class.
     */
    public UserEntity() {}

    /**
     * Parameterized constructor for the UserEntity class.
     *
     * @param email    The user's email.
     * @param username The user's username.
     * @param password The user's password.
     */
    public UserEntity(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return The user's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param id The user's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email of the user.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The user's username.
     */
    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities/roles for the user
        // For example, you might have a role called "ROLE_USER"
        // You can use SimpleGrantedAuthority for simplicity
        // You might have more complex logic based on your application's roles and permissions
        return List.of(new SimpleGrantedAuthority(SpringSecurityConfig.ROLE_USER));
    }

}
