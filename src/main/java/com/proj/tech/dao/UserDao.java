package com.proj.tech.dao;

import com.proj.tech.model.UserEntity;
import com.proj.tech.model.UserProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository interface for accessing and managing user entities in the database.
 */
public interface UserDao extends JpaRepository<UserEntity, Long> {

    /**
     * Finds a user professor by username.
     *
     * @param username The username of the user professor to find.
     * @return The user professor entity with the specified username.
     */
    @Query("select user from UserProfessorEntity user where user.username=:username")
    UserProfessorEntity findByUsername(@Param("username") String username);
}
