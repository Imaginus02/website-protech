package com.proj.tech.mapper.blocks;

import com.proj.tech.dto.blocks.Code;
import com.proj.tech.model.blocks.CodeEntity;

import java.util.stream.Collectors;

public class CodeMapper {
    public static Code of (CodeEntity code) {
        return new Code(
                code.getId(),
                code.getName(),
                code.getInstructions().stream().map(InstructionMapper::of).collect(Collectors.toList())
        );
    }
}
