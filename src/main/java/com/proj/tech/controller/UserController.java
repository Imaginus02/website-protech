package com.proj.tech.controller;

import com.proj.tech.dao.UserDao;
import com.proj.tech.dao.UserProfessorDao;
import com.proj.tech.dto.UserProfessor;
import com.proj.tech.dto.UserProfessorCommand;
import com.proj.tech.dto.UserUpdate;
import com.proj.tech.mapper.UserMapper;
import com.proj.tech.mapper.UserProfessorMapper;
import com.proj.tech.model.UserProfessorEntity;
import com.proj.tech.security.SpringSecurityConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
import java.util.Map;
import java.util.stream.Collectors;

//@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin
@RestController
@RequestMapping("/api/users")
@Transactional
public class UserController {

    private final UserProfessorDao userProfessorDao;
    private final UserDetailsService userDetailsService;

    public UserController(UserProfessorDao userProfessorDao,
                          UserDetailsService userDetailsService) {
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
    public List<UserProfessor> listUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList().contains("ROLE_ADMIN")) {
            System.out.println("Admin here, providing full session list");
            return userProfessorDao.findAll().stream()
                    .map(UserProfessorMapper::of)
                    .toList();
        } else {
            System.out.println("Simple user, providing only session created by this user");
            return List.of(UserProfessorMapper.of(userProfessorDao.findByUsername(authentication.getName())));

        }
    }

    @PostMapping("/{id}")
    @ResponseBody
    public UserProfessor updateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate) {
        System.out.println("Post request received");
        UserProfessorEntity user = userProfessorDao.findById(id).get();
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        System.out.println("Json received :");
        System.out.println(userUpdate.getProperties());
        Map<String, Object> properties = userUpdate.getProperties();
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        if (properties.containsKey("username")) {
            System.out.println("Changing username");
            String newUsername = (String) properties.get("username");
            user.setUsername(newUsername);
            UserDetails updatedUserDetails = new User(newUsername, encoder.encode(user.getPassword()), userDetails.getAuthorities());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(updatedUserDetails, null, updatedUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        if (properties.containsKey("email")) {
            System.out.println("Changing email");
            user.setEmail((String) properties.get("email"));
        }
        if (properties.containsKey("password")) {
            System.out.println("Changing password");
            String newPassword = (String) properties.get("password");
            user.setPassword((String) properties.get("password"));
            UserDetails updatedUserDetails = new User(user.getUsername(), encoder.encode(newPassword), userDetails.getAuthorities());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(updatedUserDetails, null, updatedUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        UserProfessorEntity saved = userProfessorDao.save(user);
        return UserProfessorMapper.of(saved);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserProfessor showUser(@PathVariable Long id) {
        UserProfessor user = UserProfessorMapper.of(userProfessorDao.findById(id).get());
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






