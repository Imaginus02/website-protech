//package com.proj.tech.services;
//
//import com.proj.tech.dao.UserProfessorDao;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserProfessorDetailsService  implements UserDetailsService {
//
//    private final UserProfessorDao userProfessorDao;
//
//    public UserProfessorDetailsService(UserProfessorDao userProfessorDao) {
//        this.userProfessorDao = userProfessorDao;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userProfessorDao.findByUsername(username);
//    }
//}
