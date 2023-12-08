package com.proj.tech.controller;

import com.proj.tech.dao.UserDao;
import com.proj.tech.dto.User;
import com.proj.tech.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Transactional
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

//    @GetMapping
//    public String listUsers(Model model) {
//        return "userList";
//    }

    @GetMapping
    @ResponseBody
    public List<User> listUsers() {
        List<User> users = userDao.findAll().stream()
                .map(UserMapper::of)
                .collect(Collectors.toList());
        System.out.println("Acceding to users page");
        System.out.println(users);
        return users;
    }
}






