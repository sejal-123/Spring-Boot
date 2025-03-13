package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.Users;
import com.example.SpringSecurity.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepo repo;

    public Users addUser(Users user) {
        return repo.save(user);
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }
}
