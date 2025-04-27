package com.example.JournalApp.service;

import com.example.JournalApp.model.User;
import com.example.JournalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User findByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    public void deleteByUserName(String username) {
        userRepo.deleteByUsername(username);
    }

    public User createUser(User user) {
        try {
            return userRepo.save(user);
        } catch (Exception e) {
            log.error("Error occurred while creating user {}", user.getUsername(), e);
        }
        return null;
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
