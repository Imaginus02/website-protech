package com.proj.tech.dto.blocks;

import java.util.List;

public record Code(Long id, String name, List<Instruction> instructions) {
}
