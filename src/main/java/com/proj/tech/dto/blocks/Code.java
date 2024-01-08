package com.proj.tech.dto.blocks;

import com.proj.tech.dto.UserProfessor;

import java.util.List;

/**
 * A Data Transfer Object (DTO) representing information about a code block.
 * <p>
 * This record encapsulates the essential details of a code block, including its unique identifier,
 * name, list of instructions, and the identifier of the user who created it.
 * </p>
 *
 * @param id           The unique identifier of the code block.
 * @param name         The name or title of the code block.
 * @param instructions The list of instructions associated with the code block.
 * @param creatorId    The unique identifier of the user who created the code block.
 */
public record Code(Long id, String name, List<Instruction> instructions, Long creatorId) {
}
