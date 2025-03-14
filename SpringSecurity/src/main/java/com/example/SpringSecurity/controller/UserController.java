package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.Users;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @GetMapping("/users")
    public List<Users> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/register")
    public Users addUser(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return service.addUser(user);
    }

    @PostMapping("/login")
    public String verify(@RequestBody Users user) {
        System.out.println(user);
        return service.verifyUser(user);
    }
}
