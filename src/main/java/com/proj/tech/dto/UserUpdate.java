package com.proj.tech.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing an update request for a user's information.
 *
 * <p>
 * This class is used in conjunction with a record (e.g., {@code UserProfessorCommand}) to update specific
 * properties (email, username, password) of a user individually. Only one of the three properties should
 * be provided at a time in a single update request.
 * </p>
 *
 * <p>
 * The class utilizes a map to store the properties to be updated, with the field name as the key and the
 * corresponding value to be set.
 * </p>
 *
 * <p>
 * Note: This class is designed to be used with records for handling user updates.
 * </p>
 *
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * {@code
 * UserUpdate update = new UserUpdate();
 * update.set("email", "new.email@example.com");
 * Map<String, Object> properties = update.getProperties();
 * // properties will contain {"email": "new.email@example.com"}
 * }
 * </pre>
 */
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
