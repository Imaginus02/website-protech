package com.proj.tech.controller;

import com.proj.tech.dao.SessionDao;
import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.Session;
import com.proj.tech.mapper.SessionMapper;
import com.proj.tech.model.SessionEntity;
import com.proj.tech.model.SessionStatus;
import com.proj.tech.model.UserProfessorEntity;
import com.proj.tech.services.StringToDateConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sessions")
@Transactional
public class SessionController {

    private final SessionDao sessionDao;

    private final UserProfessorDao userProfessorDao;

    private final StringToDateConverter stringToDateConverter;

    public SessionController(SessionDao sessionDao, UserProfessorDao userProfessorDao) {
        this.sessionDao = sessionDao;
        this.userProfessorDao = userProfessorDao;
        this.stringToDateConverter = new StringToDateConverter();
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
                                                 @RequestParam String username,
                                                 @RequestParam Integer maxUser,
                                                 @RequestParam String endDate) {
        UserProfessorEntity user = userProfessorDao.findByUsername(username);
        SessionEntity saved = sessionDao.save(new SessionEntity(name, user, maxUser, stringToDateConverter.convertStringToDate(endDate)));
        return ResponseEntity.ok(SessionMapper.of(saved));
    }

//    @GetMapping
//    @ResponseBody
//    public Date now() {
//        return Date.from(Instant.now());
//    }
}
