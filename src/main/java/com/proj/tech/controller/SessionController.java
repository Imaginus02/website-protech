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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.proj.tech.security.SpringSecurityConfig.ROLE_ADMIN;

@CrossOrigin
@RestController
@RequestMapping("/api/sessions")
@Transactional
public class SessionController {

    private final SessionDao sessionDao;

    private final UserProfessorDao userProfessorDao;

    private final StringToDateConverter stringToDateConverter;

    private final UserDetailsService userDetailsService;

    public SessionController(SessionDao sessionDao,
                             UserProfessorDao userProfessorDao,
                             UserDetailsService userDetailsService) {
        this.sessionDao = sessionDao;
        this.userProfessorDao = userProfessorDao;
        this.stringToDateConverter = new StringToDateConverter();
        this.userDetailsService = userDetailsService;
    }

    @GetMapping()
    public List<Session> listSessions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
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

    @GetMapping("/{username}")
    public List<Session> listSessionForUser(@PathVariable String username) {
        return sessionDao.findByUser(username)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    @GetMapping("/{username}/active")
    @ResponseBody
    public List<Session> listActiveSessionForUser(@PathVariable String username) {
        return sessionDao.findByUserAndStatus(username, SessionStatus.ACTIVE)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    @GetMapping("/{username}/archived")
    @ResponseBody
    public List<Session> listArchivedSessionForUser(@PathVariable String username) {
        return sessionDao.findByUserAndStatus(username, SessionStatus.ARCHIVED)
                .stream()
                .map(SessionMapper::of)
                .toList();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Session> createSession(@RequestParam String name,
                                                 @RequestParam Integer maxUser,
                                                 @RequestParam String endDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
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
        System.out.println("Created new user with credentials: "+sessionUser.getUsername() + "Encrypted password" + sessionUser.getPassword() + "decrypted password" + saved.getPassword());
        return ResponseEntity.ok(SessionMapper.of(saved));
    }
}
