package com.proj.tech.mapper.blocks;

import com.proj.tech.dto.blocks.Code;
import com.proj.tech.model.blocks.CodeEntity;

import java.util.stream.Collectors;

/**
 * Mapper class for converting {@code CodeEntity} instances to {@code Code} DTOs.
 */
public class CodeMapper {

    /**
     * Converts a {@code CodeEntity} to a {@code Code} DTO.
     *
     * @param code The {@code CodeEntity} to be converted.
     * @return The corresponding {@code Code} DTO.
     */
    public static Code of (CodeEntity code) {
        return new Code(
                code.getId(),
                code.getName(),
                code.getInstructions().stream().map(InstructionMapper::of).collect(Collectors.toList()),
                code.getCreator().getId()
        );
    }
}
