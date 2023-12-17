package com.proj.tech.controller;

import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.mapper.blocks.CodeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/codes")
@Transactional
public class CodeController {

    private final CodeDao codeDao;

    public CodeController(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @GetMapping
    public List<Code> listCode() {
        return codeDao.findAll()
                .stream()
                .map(CodeMapper::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Code getCode(@PathVariable Long id) {

        return codeDao.findById(id).map(CodeMapper::of).orElse(null);
    }

    @GetMapping("/{username}")
    public List<Code> getCodeByUsername(@PathVariable String username) {
        return codeDao.findByUsername(username).stream().map(CodeMapper::of).collect(Collectors.toList());
    }
}
