package com.proj.tech.model;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserProfessorEntity user) {
        this.user = user;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SessionEntity() {
    }

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