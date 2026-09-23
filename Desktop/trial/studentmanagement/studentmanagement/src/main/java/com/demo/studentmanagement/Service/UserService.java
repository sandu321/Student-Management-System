package com.demo.studentmanagement.Service;

import com.demo.studentmanagement.Entity.User;
import com.demo.studentmanagement.Repository.UserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserData userData;

    public UserService(UserData userData) {
        this.userData = userData;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println("USERNAME RECEIVED = " + username);

        User user = userData.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
        System.out.println("LOGIN USER = " + user.getUsername() + " ROLE = " + user.getRole());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}