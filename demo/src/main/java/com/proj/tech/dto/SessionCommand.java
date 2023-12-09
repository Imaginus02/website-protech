package com.proj.tech.dto;

import java.util.Date;

public record SessionCommand(String name, String username, Integer maxUser, Date endDate) {
}
