package com.proj.tech.dao.blocks;

import com.proj.tech.model.UserEntity;
import com.proj.tech.model.blocks.InstructionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructionDao extends JpaRepository<InstructionEntity, Long> {
}
