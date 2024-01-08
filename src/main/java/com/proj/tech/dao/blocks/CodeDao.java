package com.proj.tech.dao.blocks;

import com.proj.tech.model.blocks.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for accessing and managing code entities in the database.
 */
public interface CodeDao extends JpaRepository<CodeEntity, Long> {

    /**
     * Retrieves a list of codes created by a specific user.
     *
     * @param username The username of the user who created the codes.
     * @return A list of codes created by the specified user.
     */
    @Query("select code from CodeEntity code join UserProfessorEntity user on user.id = code.creator.id where user.username=:username")
    List<CodeEntity> findByUsername(@Param("username") String username);
}
