package com.dileep.SpringSecurityProject.service;

import com.dileep.SpringSecurityProject.model.Users;
import com.dileep.SpringSecurityProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("hello");
        System.out.println(user.getPassword());
        return repo.save(user);
    }

    public String verify(Users user) {
        System.out.println("Hello");
        System.out.println(user.getPassword() + user.getUsername());
        String userName = user.getUsername();
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userName);
        }
        return "fail";
    }
}
