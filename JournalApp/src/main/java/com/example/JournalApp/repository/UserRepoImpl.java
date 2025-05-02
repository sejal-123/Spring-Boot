package com.example.JournalApp.repository;

import com.example.JournalApp.model.User;
import com.example.JournalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepoImpl {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    EmailService emailService;

    public List<User> getUserSA() {
        Query query = new Query();
//        query.addCriteria(Criteria.where("email").exists(true));
        query.addCriteria(Criteria.where("email").ne("").ne(null));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        List<User> users = mongoTemplate.find(query, User.class);
        for (User user: users) {
            emailService.sendEmail(user.getEmail(), "Test mail", "Hello, How are you?");
        }
        return users;
    }
}
