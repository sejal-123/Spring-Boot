package com.example.test_junit.controller;

import com.example.test_junit.model.User;
import com.example.test_junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }
}
