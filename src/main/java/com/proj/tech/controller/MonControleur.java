package com.proj.tech.controller;

import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dao.blocks.InstructionDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.UserEntity;
import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;
import com.proj.tech.services.JavaArduinoTranslator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.*;

@Controller
@CrossOrigin
public class MonControleur {

    private final CodeDao codeDao;
    private final UserProfessorDao userProfessorDao;
    private final InstructionDao instructionDao;


    private final JavaArduinoTranslator javaArduinoTranslator = new JavaArduinoTranslator();

    public MonControleur(CodeDao codeDao, InstructionDao instructionDao, UserProfessorDao userProfessorDao) {
        this.codeDao = codeDao;
        this.instructionDao = instructionDao;
        this.userProfessorDao = userProfessorDao;
    }

    @PostMapping("/maPage") // "/maPage" correspond à <form action="/maPage" method="post">
    public String maPage(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        params.remove("validForm");

        List<String> newList = new ArrayList<>();
        for (String key : params.keySet()) {
            newList.add(params.get(key)[0]);
        }

        System.out.println(newList);

        return "redirect:/mainPage.html";

    }

    @PostMapping("/savePage")
    public String save(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        // params.remove("validForm");
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                System.out.println("Paramètre " + key + " : " + value);
            }
        }
//        params = new LinkedHashMap<>();
        saveCode(params);
        return "redirect:/mainPage.html";
    }

    @GetMapping("/login/student")
    public String showLoginStudentPage() {
        return "login.html"; // Returns login.html
    }

    @GetMapping("/login/professor")
    public String showLoginProfessorPage() {
        return "loginProf.html"; // Returns login.html
    }

    @GetMapping("/choose")
    public String showChoosePage() {
        return "choose.html"; // Returns login.html
    }

    @GetMapping("/inscription")
    public String showRegisterPage() {
        return "inscription.html"; // Returns login.html
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "profile.html";
    }

    @GetMapping("/login-successful")
    public String redirectWithAuthority() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_PROFESSOR")) {
            return "redirect:/mainPage.html?prof=true";
        } else {
            return "redirect:/mainPage.html";
        }
    }


    public Code saveCode(Map<String, String[]> params) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userProfessorDao.findByUsername(authentication.getName());
        Set<InstructionEntity> instructions = new HashSet<>(Set.of());
        CodeEntity code = new CodeEntity(params.get("nameOfCode")[0]);
        CodeEntity saved = codeDao.save(code);
        params.remove("nameOfCode");
        int compteur = 0;
        for (String key : params.keySet()) {
            instructions.add(new InstructionEntity(params.get(key)[0], javaArduinoTranslator.translate(params.get(key)[0]), code, compteur));
            compteur += 1;
        }
        instructionDao.saveAll(instructions);
        code.setInstructions(instructions);

        return new CodeMapper().of(saved);
    }
}
