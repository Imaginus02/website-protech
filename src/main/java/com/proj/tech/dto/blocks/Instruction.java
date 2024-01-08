package com.proj.tech.dto.blocks;

/**
 * A Data Transfer Object (DTO) representing information about an instruction within a code block.
 * <p>
 * This record encapsulates the essential details of an instruction, including its unique identifier,
 * name, character representation, the identifier of the associated code block, and its order within the code.
 * </p>
 *
 * @param id          The unique identifier of the instruction.
 * @param name        The name or description of the instruction.
 * @param instruction The character representation of the instruction.
 * @param codeId      The unique identifier of the code block to which the instruction belongs.
 * @param orderInCode The order or position of the instruction within the associated code block.
 */
public record Instruction(Long id, String name, Character instruction, Long codeId, Long orderInCode) {
}
