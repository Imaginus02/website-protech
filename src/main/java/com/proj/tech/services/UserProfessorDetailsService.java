//package com.proj.tech.services;
//
//import com.proj.tech.dao.UserProfessorDao;
//import com.proj.tech.model.UserProfessorEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service("userDetailsService")
//public class UserProfessorDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserProfessorDao userProfessorDao;
//
////    public UserProfessorDetailsService(UserProfessorDao userProfessorDao) {
////        this.userProfessorDao = userProfessorDao;
////    }
//
////    public UserProfessorDetailsService() {}
//
//
//    @Transactional(readOnly = true)
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userProfessorDao.findByUsername(username);
////            List<GrantedAuthority> authorities = buildUserAuthority(userProfessorEntity.getUserRole());
//    }
//
//    private User buildUserProfessorEntityForAuthentication(UserProfessorEntity userProfessorEntity, List<GrantedAuthority> authorities) {
//        return new User(userProfessorEntity.getUsername(), userProfessorEntity.getPassword(), userProfessorEntity.isEnabled(), true, true, true, authorities);
//    }
//
////    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
////
////        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
////
////        // add user's authorities
////        for (UserRole userRole : userRoles) {
////            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
////        }
////
////        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
////
////        return Result;
////    }
//}
//
