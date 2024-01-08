package com.proj.tech.controller;

import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.dto.blocks.Instruction;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;
import com.proj.tech.services.CodeToStringTranslator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.proj.tech.ProjTechApplication.logger;
import static java.util.Arrays.stream;

/**
 * Controller handling requests related to code execution and retrieval.
 * This controller manages posting code execution requests and retrieving a list of code requests.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/request")
@Transactional
public class RequestController {

    private final CodeDao codeDao;

    private final CodeToStringTranslator codeToStringTranslator;

    /**
     * Constructs a new instance of the RequestController.
     *
     * @param codeDao                The data access object for managing Code entities.
     */
    public RequestController(CodeDao codeDao) {
        this.codeDao = codeDao;
        this.codeToStringTranslator = new CodeToStringTranslator();
    }

    /**
     * Handles the HTTP POST request to submit a code execution request.
     *
     * @param codeId The ID of the code to be executed.
     * @return ResponseEntity with the result of the code execution in the form of a Code DTO.
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Code> postRequest(@RequestParam Long codeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("POST request to /api/request by " + authentication.getName());
        CodeEntity code = codeDao.findById(codeId).orElse(null);
        /*
        * Run the code here
        */
        return ResponseEntity.ok(CodeMapper.of(code));
    }

    /**
     * Handles the HTTP GET request to retrieve a list of code execution requests.
     *
     * @return A list of Strings representing the code execution requests.
     */
    @GetMapping
    @ResponseBody
    public List<String> getRequests() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET request to /api/request by " + authentication.getName());
        List<CodeEntity> codes = codeDao.findAll();
        List<String> result = new java.util.ArrayList<>(List.of());
        for (CodeEntity code : codes) {
            result.add(codeToStringTranslator.translate(code));
        }
        return result;
    }
}
