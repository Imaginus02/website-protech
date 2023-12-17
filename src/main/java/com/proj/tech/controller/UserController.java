package com.proj.tech.controller;

import com.proj.tech.dao.UserDao;
import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.User;
import com.proj.tech.dto.UserProfessor;
import com.proj.tech.dto.UserProfessorCommand;
import com.proj.tech.mapper.UserMapper;
import com.proj.tech.mapper.UserProfessorMapper;
import com.proj.tech.model.UserProfessorEntity;
import com.proj.tech.security.SpringSecurityConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    private final UserDao userDao;
    private final UserProfessorDao userProfessorDao;
    private final UserDetailsService userDetailsService;

    public UserController(UserDao userDao,
                          UserProfessorDao userProfessorDao,
                          UserDetailsService userDetailsService) {
        this.userDao = userDao;
        this.userProfessorDao = userProfessorDao;
        this.userDetailsService = userDetailsService;
    }

//    @GetMapping
//    public String listUsers(Model model) {
//        return "userList";
//    }

    /*
     * Si L'utilisateur a le rôle admin, alors il on lui envoit tout les users, sinon on lui renvoit que lui dans une liste
     */
    @GetMapping
    @ResponseBody
    public List<User> listUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_ADMIN")) {
            System.out.println("Admin here, providing full session list");
            return userDao.findAll().stream()
                    .map(UserMapper::of)
                    .toList();
        } else {
            System.out.println("Simple user, providing only session created by this user");
            return List.of(UserMapper.of(userDao.findByUsername(authentication.getName())));

        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User showUser(@PathVariable Long id) {
        User user = UserMapper.of(userProfessorDao.findById(id).get());
        System.out.println("Acceding to users page");
        System.out.println(user);
        return user;
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<UserProfessor> createUser(@RequestBody UserProfessorCommand user) {
        UserProfessorEntity saved = userProfessorDao.save(new UserProfessorEntity(user.email(), user.username(), user.password()));

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails userProfessor = org.springframework.security.core.userdetails.User.withUsername(saved.getUsername())
                .password(encoder.encode(saved.getPassword()))
                .roles(SpringSecurityConfig.ROLE_PROFESSOR)
                .build();
        if (userDetailsService instanceof InMemoryUserDetailsManager) {
            ((InMemoryUserDetailsManager) userDetailsService).createUser(userProfessor);
        }

        return ResponseEntity.ok(UserProfessorMapper.of(saved));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        if (userDetailsService instanceof InMemoryUserDetailsManager) {
            ((InMemoryUserDetailsManager) userDetailsService).deleteUser(userProfessorDao.findById(id).get().getUsername());
        }
        userProfessorDao.deleteById(id);
    }
}






