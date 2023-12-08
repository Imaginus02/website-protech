package com.proj.tech.dao.blocks;

import com.proj.tech.model.UserEntity;

import java.util.List;

public interface InstructionDao {
    List<UserEntity> findByCode(Long id);
}
