package com.proj.tech.controller;

import com.proj.tech.dao.blocks.InstructionDao;
import com.proj.tech.dto.blocks.Instruction;
import com.proj.tech.mapper.blocks.InstructionMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/instructions")
@Transactional
public class InstructionController {

    private final InstructionDao instructionDao;

    public InstructionController(InstructionDao instructionDao) {
        this.instructionDao = instructionDao;
    }

    @GetMapping
    public List<Instruction> listInstruction() {
        return instructionDao.findAll()
                .stream()
                .map(InstructionMapper::of)
                .toList();
    }
}
