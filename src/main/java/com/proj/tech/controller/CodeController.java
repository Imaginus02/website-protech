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

import static com.proj.tech.ProjTechApplication.logger;

/**
 * Controller handling operations related to code management.
 * This controller manages listing codes and retrieving code information.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/codes")
@Transactional
public class CodeController {

    private final CodeDao codeDao;
    private final UserProfessorDao userProfessorDao;

    /**
     * Constructs a new instance of the CodeController.
     *
     * @param codeDao           The data access object for managing Code entities.
     * @param userProfessorDao  The data access object for managing UserProfessor entities.
     */
    public CodeController(CodeDao codeDao, UserProfessorDao userProfessorDao) {
        this.codeDao = codeDao;
        this.userProfessorDao = userProfessorDao;
    }

    /**
     * Handles the HTTP GET request to retrieve a list of codes.
     * If the user has the role admin, all codes are provided; if the user has the role professor, only codes created by the professor are provided.
     *
     * @return A list of Code DTOs representing the codes.
     */
    @GetMapping
    public List<Code> listCode() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Get request to /api/codes by " + authentication.getName());
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_ADMIN")) {
            logger.debug("Admin here, providing full session list");
            return codeDao.findAll()
                    .stream()
                    .map(CodeMapper::of)
                    .toList();
        } else if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_PROFESSOR")){
            logger.debug("Simple user, providing only session created by this user");
            UserProfessorEntity userProfessor = userProfessorDao.findByUsername(authentication.getName());
            return codeDao.findByUsername(userProfessor.getUsername())
                    .stream()
                    .map(CodeMapper::of)
                    .toList();
        } else {
            logger.warn("Unauthorized access to /api/codes");
            return List.of();
        }
    }

    /**
     * Handles the HTTP GET request to retrieve a specific code by ID.
     *
     * @param id The ID of the code to be retrieved.
     * @return A Code DTO representing the retrieved code.
     */
    @GetMapping("/{id}")
    public Code getCode(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Get request to /api/codes/" + id + " by " + authentication.getName());
        return codeDao.findById(id).map(CodeMapper::of).orElse(null);
    }

    /**
     * Handles the HTTP GET request to retrieve a list of codes for a specific user by username.
     *
     * @param username The username of the user for whom codes are retrieved.
     * @return A list of Code DTOs representing the codes for the specified user.
     */
    @GetMapping("/{username}")
    public List<Code> getCodeByUsername(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Get request to /api/codes/" + username + " by " + authentication.getName());
        return codeDao.findByUsername(username).stream().map(CodeMapper::of).collect(Collectors.toList());
    }
}
