package com.proj.tech.mapper.blocks;

import com.proj.tech.dto.blocks.Instruction;
import com.proj.tech.model.blocks.InstructionEntity;

public class InstructionMapper {
    public static Instruction of(InstructionEntity instruction) {
        return new Instruction(
                instruction.getId(),
                instruction.getName(),
                instruction.getInstruction(),
                instruction.getCode().getId()
        );
    }
}
