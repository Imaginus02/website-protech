package com.proj.tech.dto.blocks;

import com.proj.tech.dto.UserProfessor;

import java.util.List;

public record Code(Long id, String name, List<Instruction> instructions, Long creatorId) {
}
