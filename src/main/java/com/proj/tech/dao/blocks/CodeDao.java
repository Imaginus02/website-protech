package com.proj.tech.dao.blocks;

import com.proj.tech.model.blocks.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeDao extends JpaRepository<CodeEntity, Long> {

    @Query("select code from CodeEntity code join UserProfessorEntity user on user.id = code.creator.id where user.username=:username")
    List<CodeEntity> findByUsername(@Param("username") String username);
}
