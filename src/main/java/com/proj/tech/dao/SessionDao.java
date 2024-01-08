package com.proj.tech.dao;

import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for accessing and managing sessions in the database.
 */
public interface SessionDao extends JpaRepository<SessionEntity, Long> {

    /**
     * Retrieves a list of sessions with the specified status.
     *
     * @param status The status of the sessions to retrieve.
     * @return A list of sessions with the specified status.
     */
    List<SessionEntity> findByStatus(SessionStatus status);

    /**
     * Finds a session by its name.
     *
     * @param name The name of the session to find.
     * @return The session entity with the specified name.
     */
    @Query("select s from SessionEntity s where s.name=:name")
    SessionEntity findByName(@Param("name") String name);

    /**
     * Deletes a session by its name.
     *
     * @param name The name of the session to delete.
     */
    @Modifying
    @Query("delete from SessionEntity s where s.name = ?1")
    void deleteByName(String name);

    /**
     * Retrieves a list of sessions created by a specific user.
     *
     * @param username The username of the user who created the sessions.
     * @return A list of sessions created by the specified user.
     */
    @Query("select s from SessionEntity s where s.user.username=:username")
    List<SessionEntity> findByUser(@Param("username") String username);

    /**
     * Retrieves a list of sessions with a specific status created by a specific user.
     *
     * @param username The username of the user who created the sessions.
     * @param status   The status of the sessions to retrieve.
     * @return A list of sessions with the specified status created by the specified user.
     */
    @Query("select s from SessionEntity s where s.user.username=:username and s.status=:status")
    List<SessionEntity> findByUserAndStatus(@Param("username") String username, @Param("status") SessionStatus status);

}
