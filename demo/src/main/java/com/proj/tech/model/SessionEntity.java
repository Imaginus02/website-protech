package com.proj.tech.model;


import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "SP_SESSION")
public class SessionEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@ManyToOne(optional = false)
	private UserEntity user;

	@Column(nullable = false)
	private SessionStatus status;

	@Column(nullable = false)
	private String password;

	@Column(nullable = true)
	private Integer nombreMax;

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

	public void setUser(UserEntity user) {
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

	public Integer getNombreMax() {
		return nombreMax;
	}

	public void setNombreMax(Integer nombreMax) {
		this.nombreMax = nombreMax;
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

	public SessionEntity(Long id, String name, UserEntity user, SessionStatus status, String password, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.status = status;
		this.password = password;
		this.startDate = startDate;
		this.endDate = endDate;
	}


}