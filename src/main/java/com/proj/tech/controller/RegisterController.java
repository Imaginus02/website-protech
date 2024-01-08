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

import static com.proj.tech.ProjTechApplication.logger;

/**
 * Controller handling registration-related operations for professors.
 * This controller manages user registration, validation, and redirects.
 */
@CrossOrigin
@Controller
@RequestMapping("/inscription")
public class RegisterController {

    private final UserDetailsService userDetailsService;

    private final UserProfessorDao userProfessorDao;

    /**
     * Constructs a new instance of the RegisterController.
     *
     * @param userProfessorDao   The data access object for managing UserProfessor entities.
     * @param userDetailsService The service for loading user-specific data.
     */
    public RegisterController(UserProfessorDao userProfessorDao, UserDetailsService userDetailsService) {
        this.userProfessorDao = userProfessorDao;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Handles the HTTP POST request for user registration.
     *
     * @param username         The username provided in the registration form.
     * @param email            The email provided in the registration form.
     * @param password         The password provided in the registration form.
     * @param passwordConfirm  The confirmation password provided in the registration form.
     * @return A String representing the redirect URL based on the registration outcome.
     */
    @PostMapping
    public String registerNewProfessor(@RequestParam String username,
                                       @RequestParam String email,
                                       @RequestParam String password,
                                       @RequestParam String passwordConfirm) {

        // Verify if the user entered the same password twice
        logger.info("POST Request to /inscription with params : " + username + ", " + email + ", " + password + ", " + passwordConfirm);
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
