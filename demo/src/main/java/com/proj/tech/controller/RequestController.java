package com.proj.tech.controller;

import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.dto.blocks.Instruction;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@CrossOrigin
@RestController
@RequestMapping("/api/request")
@Transactional
public class RequestController {

    private final CodeDao codeDao;

    public RequestController(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Code> postRequest(@RequestParam Long codeId) {
        CodeEntity code = codeDao.findById(codeId).orElse(null);
        /*
        * Run the code here
        */
        return ResponseEntity.ok(CodeMapper.of(code));
    }

    @GetMapping
    @ResponseBody
    public List<String> getRequests() {
        List<CodeEntity> codes = codeDao.findAll();
        List<String> result = new java.util.ArrayList<>(List.of());
        for (CodeEntity code : codes) {
            StringBuilder tempo = new StringBuilder();
            List<InstructionEntity> sortedInstructions = code.getInstructions()
            .stream()
                    .sorted(Comparator.comparingInt((InstructionEntity::getOrderInCode)))
                    .toList();
            for (InstructionEntity instruction : code.getInstructions()) {
                tempo.append(instruction.getInstruction());
            }
            result.add(tempo.toString());
        }
        return result;
    }
}
