package com.proj.tech.controller;

import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.mapper.SessionMapper;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.UserProfessorEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UserProfessorDao userProfessorDao;

    public CodeController(CodeDao codeDao, UserProfessorDao userProfessorDao) {
        this.codeDao = codeDao;
        this.userProfessorDao = userProfessorDao;
    }

    @GetMapping
    public List<Code> listCode() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_ADMIN")) {
            System.out.println("Admin here, providing full session list");
            return codeDao.findAll()
                    .stream()
                    .map(CodeMapper::of)
                    .toList();
        } else {
            System.out.println("Simple user, providing only session created by this user");
            UserProfessorEntity userProfessor = userProfessorDao.findByUsername(authentication.getName());
            return codeDao.findByUsername(userProfessor.getUsername())
                    .stream()
                    .map(CodeMapper::of)
                    .toList();
        }
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
