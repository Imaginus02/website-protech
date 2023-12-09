package com.proj.tech.controller;

import com.proj.tech.dao.SessionDao;
import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.Session;
import com.proj.tech.dto.SessionCommand;
import com.proj.tech.dto.UserProfessor;
import com.proj.tech.mapper.SessionMapper;
import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.SessionStatus;
import com.proj.tech.model.UserEntity;
import com.proj.tech.model.UserProfessorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sessions")
@Transactional
public class SessionController {

    private final SessionDao sessionDao;

    private final UserProfessorDao userProfessorDao;

    public SessionController(SessionDao sessionDao, UserProfessorDao userProfessorDao) {
        this.sessionDao = sessionDao;
        this.userProfessorDao = userProfessorDao;
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
    public ResponseEntity<Session> createSession(@RequestBody SessionCommand session) {
        UserProfessorEntity user = userProfessorDao.findByUsername(session.username());
        SessionEntity saved = sessionDao.save(new SessionEntity(session.name(), user, session.maxUser(), session.endDate()));
        return ResponseEntity.ok(SessionMapper.of(saved));
    }

//    @GetMapping
//    @ResponseBody
//    public Date now() {
//        return Date.from(Instant.now());
//    }
}
