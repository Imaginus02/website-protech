package com.proj.tech.controller;

import com.proj.tech.dao.SessionDao;
import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.Session;
import com.proj.tech.mapper.SessionMapper;
import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.SessionStatus;
import com.proj.tech.model.UserProfessorEntity;
import com.proj.tech.security.SpringSecurityConfig;
import com.proj.tech.services.StringToDateConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.proj.tech.ProjTechApplication.logger;
import static com.proj.tech.security.SpringSecurityConfig.ROLE_ADMIN;


/**
 * Controller handling operations related to user sessions.
 * This controller manages the listing of sessions, creating new sessions, and retrieving sessions for a specific user.
 */
@CrossOrigin
@Controller
@RequestMapping("/api/sessions")
@Transactional
public class SessionController {

    private final SessionDao sessionDao;

    private final UserProfessorDao userProfessorDao;

    private final StringToDateConverter stringToDateConverter;

    private final UserDetailsService userDetailsService;

    /**
     * Constructs a new instance of the SessionController.
     *
     * @param sessionDao            The data access object for managing Session entities.
     * @param userProfessorDao      The data access object for managing UserProfessor entities.
     * @param userDetailsService    The service for loading user-specific data.
     */
    public SessionController(SessionDao sessionDao,
                             UserProfessorDao userProfessorDao,
                             UserDetailsService userDetailsService) {
        this.sessionDao = sessionDao;
        this.userProfessorDao = userProfessorDao;
        this.stringToDateConverter = new StringToDateConverter();
        this.userDetailsService = userDetailsService;
    }

    /**
     * Handles the HTTP GET request to retrieve a list of sessions.
     * Give the full list for ADMIN, and only self created for PROFESSOR
     *
     * @return A list of Session DTOs representing the sessions.
     */
    @GetMapping
    public List<Session> listSessions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("POST request to /api/sessions by " + authentication.getName());
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_ADMIN")) {
            System.out.println("Admin here, providing full session list");
            return sessionDao.findAll()
                    .stream()
                    .map(SessionMapper::of)
                    .toList();
        } else {
            System.out.println("Simple user, providing only session created by this user");
            UserProfessorEntity userProfessor = userProfessorDao.findByUsername(authentication.getName());
            return sessionDao.findByUser(userProfessor.getUsername())
                    .stream()
                    .map(SessionMapper::of)
                    .toList();
        }
    }

    /**
     * Handles the HTTP GET request to retrieve a list of sessions for a specific user.
     *
     * @param username The username of the user for whom sessions are retrieved.
     * @return A list of Session DTOs representing the sessions for the specified user.
     */
    @GetMapping("/{username}")
    public List<Session> listSessionForUser(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET request to /api/sessions/" + username + " by " + authentication.getName());
        return sessionDao.findByUser(username)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    /**
     * Handles the HTTP GET request to retrieve a list of active sessions for a specific user.
     *
     * @param username The username of the user for whom active sessions are retrieved.
     * @return A list of Session DTOs representing the active sessions for the specified user.
     */
    @GetMapping("/{username}/active")
    @ResponseBody
    public List<Session> listActiveSessionForUser(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET request to /api/sessions/" + username + "/active by " + authentication.getName());
        return sessionDao.findByUserAndStatus(username, SessionStatus.ACTIVE)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    /**
     * Handles the HTTP GET request to retrieve a list of archived sessions for a specific user.
     *
     * @param username The username of the user for whom archived sessions are retrieved.
     * @return A list of Session DTOs representing the archived sessions for the specified user.
     */
    @GetMapping("/{username}/archived")
    @ResponseBody
    public List<Session> listArchivedSessionForUser(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET request to /api/sessions/" + username + "/archived by " + authentication.getName());
        return sessionDao.findByUserAndStatus(username, SessionStatus.ARCHIVED)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    /**
     * Handles the HTTP POST request to create a new session.
     *
     * @param name     The name of the new session.
     * @param maxUser  The maximum number of users allowed in the session.
     * @param endDate  The end date of the session.
     * @return ResponseEntity with the newly created Session DTO.
     */
    @PostMapping
    public String createSession(@RequestParam String name,
                                                 @RequestParam Integer maxUser,
                                                 @RequestParam String endDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("POST request to /api/sessions by " + authentication.getName() + " with parameters : " + name + ", " + maxUser + ", " + endDate);
        if (name.isEmpty() || endDate.isEmpty()) {
            logger.error("Missing arguments");
            return "redirect:/pageTeacher.html";
        } else {
            UserProfessorEntity user = userProfessorDao.findByUsername(authentication.getName());
            SessionEntity saved = sessionDao.save(new SessionEntity(name, user, maxUser, stringToDateConverter.convertStringToDate(endDate)));

            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            UserDetails sessionUser = User.withUsername("sessions")
                    .password(encoder.encode(saved.getPassword()))
                    .roles(SpringSecurityConfig.ROLE_STUDENT)
                    .build();
            if (userDetailsService instanceof InMemoryUserDetailsManager) {
                ((InMemoryUserDetailsManager) userDetailsService).createUser(sessionUser);
            }
            System.out.println("Created new user with credentials: " + sessionUser.getUsername() + "Encrypted password" + sessionUser.getPassword() + "decrypted password" + saved.getPassword());
            return "redirect:/pageTeacher.html";
        }
    }
}
