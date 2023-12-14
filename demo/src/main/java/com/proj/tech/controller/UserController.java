package com.proj.tech.controller;

import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.User;
import com.proj.tech.dto.UserProfessor;
import com.proj.tech.dto.UserProfessorCommand;
import com.proj.tech.mapper.UserMapper;
import com.proj.tech.mapper.UserProfessorMapper;
import com.proj.tech.model.UserProfessorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Transactional
public class UserController {

    private final UserProfessorDao userProfessorDao;

    public UserController(UserProfessorDao userProfessorDao) {
        this.userProfessorDao = userProfessorDao;
    }

//    @GetMapping
//    public String listUsers(Model model) {
//        return "userList";
//    }

    @GetMapping
    @ResponseBody
    public List<User> listUsers() {
        List<User> users = userProfessorDao.findAll().stream()
                .map(UserMapper::of)
                .collect(Collectors.toList());
        System.out.println("Acceding to users page");
        System.out.println(users);
        return users;
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<UserProfessor> createUser(@RequestBody UserProfessorCommand user) {
        UserProfessorEntity saved = userProfessorDao.save(new UserProfessorEntity(user.email(), user.username(), user.password()));
        return ResponseEntity.ok(UserProfessorMapper.of(saved));
    }
}






