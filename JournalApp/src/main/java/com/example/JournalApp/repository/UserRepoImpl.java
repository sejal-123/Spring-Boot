package com.example.JournalApp.repository;

import com.example.JournalApp.model.User;
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

    public List<User> getUserSA() {
        Query query = new Query();
//        query.addCriteria(Criteria.where("email").exists(true));
        query.addCriteria(Criteria.where("email").ne("").ne(null));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
