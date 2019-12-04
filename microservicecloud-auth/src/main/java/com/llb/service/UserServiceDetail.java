package com.llb.service;


import com.llb.dao.UserDao;

import com.llb.entity.Role;
import com.llb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserDao userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        List<Role> authorities = userRepository.listByUserId(user.getId());
    return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
