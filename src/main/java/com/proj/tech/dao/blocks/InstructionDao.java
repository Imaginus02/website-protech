package com.proj.tech.dao.blocks;

import com.proj.tech.model.blocks.InstructionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing instructions in the database.
 */
public interface InstructionDao extends JpaRepository<InstructionEntity, Long> {
}
