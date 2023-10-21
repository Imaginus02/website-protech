package com.proj.tech.dao;

import com.proj.tech.dto.Session;
import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByActiveSessionsId(Long sessionId);
}
