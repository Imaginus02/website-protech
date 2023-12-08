package com.proj.tech.dao.blocks;

import com.proj.tech.model.blocks.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDao extends JpaRepository<CodeEntity, Long> {
}
