package com.proj.tech.dao;

import com.proj.tech.dto.Session;
import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionDao extends JpaRepository<SessionEntity, Long> {
    List<SessionEntity> findByStatus(SessionStatus status);

    @Query("select s from SessionEntity s where s.name=:name")
    SessionEntity findByName(@Param("name") String name);

    @Modifying
    @Query("delete from SessionEntity s where s.name = ?1")
    void deleteByName(String name);

    @Query("select s from SessionEntity s where s.user.username=:username")
    List<SessionEntity> findByUser(@Param("username") String username);

    @Query("select s from SessionEntity s where s.user.username=:username and s.status=:status")
    List<SessionEntity> findByUserAndStatus(@Param("username") String username, @Param("status") SessionStatus status);

}
