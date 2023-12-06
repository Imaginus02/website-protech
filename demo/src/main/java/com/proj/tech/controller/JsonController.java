package com.proj.tech.controller;

import com.proj.tech.dao.UserDao;
import com.proj.tech.dto.User;
import com.proj.tech.mapper.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasRole('ADMIN')")
@Controller
public class JsonController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public String listUsers(Model model) {
        return "userList";
    }

    @GetMapping("/users/json")
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






