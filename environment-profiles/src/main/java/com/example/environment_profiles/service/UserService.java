package com.example.environment_profiles.service;

import com.example.environment_profiles.model.User;
import com.example.environment_profiles.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public ResponseEntity<String> addUser(User user) {
        User user1 = userRepo.save(user);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUser(int id) {
        User user = userRepo.findById(id).get();
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
