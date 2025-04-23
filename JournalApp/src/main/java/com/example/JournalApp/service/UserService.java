package com.example.JournalApp.service;

import com.example.JournalApp.model.User;
import com.example.JournalApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
