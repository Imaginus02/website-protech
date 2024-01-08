package com.proj.tech.mapper.blocks;

import com.proj.tech.dto.blocks.Instruction;
import com.proj.tech.model.blocks.InstructionEntity;

/**
 * Mapper class for converting {@code InstructionEntity} instances to {@code Instruction} DTOs.
 */
public class InstructionMapper {

    /**
     * Converts an {@code InstructionEntity} to an {@code Instruction} DTO.
     *
     * @param instruction The {@code InstructionEntity} to be converted.
     * @return The corresponding {@code Instruction} DTO.
     */
    public static Instruction of(InstructionEntity instruction) {
        return new Instruction(
                instruction.getId(),
                instruction.getName(),
                instruction.getInstruction(),
                instruction.getCode().getId(),
                instruction.getOrderInCode().longValue()
        );
    }
}
