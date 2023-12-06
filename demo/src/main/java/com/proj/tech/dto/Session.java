package com.proj.tech.dto;

import com.proj.tech.model.SessionStatus;

import java.util.Date;

public record Session(Long id, String name, Long userId, SessionStatus status, String password, Integer nombreMax, Date startDate, Date endDate) {
}
