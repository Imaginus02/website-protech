package com.proj.tech.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class UserUpdate {
    @JsonIgnore
    private final Map<String, Object> properties = new HashMap<>();

    @JsonAnySetter
    public void set(String fieldName, Object value) {
        properties.put(fieldName,value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
}
