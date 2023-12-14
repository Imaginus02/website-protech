package com.proj.tech.controller;

import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.blocks.CodeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/request")
@Transactional
public class RequestController {

    private CodeDao codeDao;

    public RequestController(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Code> getRequest(@RequestParam Long codeId) {
        CodeEntity code = codeDao.findById(codeId).orElse(null);
        return ResponseEntity.ok(CodeMapper.of(code));
    }
}
