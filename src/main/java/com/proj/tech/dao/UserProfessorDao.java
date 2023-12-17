package com.proj.tech.dao;

import com.proj.tech.model.UserProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProfessorDao extends JpaRepository<UserProfessorEntity, Long> {

    List<UserProfessorEntity> findByActiveSessionsId(Long sessionId);

    @Query("select user from UserProfessorEntity user where user.username=:username")
    UserProfessorEntity findByUsername(@Param("username") String username);
}
