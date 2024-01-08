package com.proj.tech.dao;

import com.proj.tech.model.UserProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for accessing and managing user professor entities in the database.
 */
public interface UserProfessorDao extends JpaRepository<UserProfessorEntity, Long> {

    /**
     * Finds user professor entities by the ID of an active session.
     *
     * @param sessionId The ID of the active session.
     * @return A list of user professor entities associated with the specified active session.
     */
    List<UserProfessorEntity> findByActiveSessionsId(Long sessionId);

    /**
     * Finds a user professor by username.
     *
     * @param username The username of the user professor to find.
     * @return The user professor entity with the specified username.
     */
    @Query("select user from UserProfessorEntity user where user.username=:username")
    UserProfessorEntity findByUsername(@Param("username") String username);
}
