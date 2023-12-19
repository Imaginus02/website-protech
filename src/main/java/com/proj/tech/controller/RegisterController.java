package com.proj.tech.controller;

import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.model.UserProfessorEntity;
import com.proj.tech.security.SpringSecurityConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/inscription")
public class RegisterController {

    private final UserDetailsService userDetailsService;

    private final UserProfessorDao userProfessorDao;

    public RegisterController(UserProfessorDao userProfessorDao, UserDetailsService userDetailsService) {
        this.userProfessorDao = userProfessorDao;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public String registerNewProfessor(@RequestParam String username,
                                       @RequestParam String email,
                                       @RequestParam String password,
                                       @RequestParam String passwordConfirm) {

        // Verify if the user entered the same password twice
        if (!password.equals(passwordConfirm))
            return "redirect:/inscription?error=true";

        // Save the new user into the database
        UserProfessorEntity user = new UserProfessorEntity(email, username, password);
        UserProfessorEntity saved = userProfessorDao.save(user);

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails userProfessor = User.withUsername(saved.getUsername())
                .password(encoder.encode(saved.getPassword()))
                .roles(SpringSecurityConfig.ROLE_PROFESSOR)
                .build();
        if (userDetailsService instanceof InMemoryUserDetailsManager) {
            ((InMemoryUserDetailsManager) userDetailsService).createUser(userProfessor);
        }

        return "redirect:/login/professor";
    }
}
