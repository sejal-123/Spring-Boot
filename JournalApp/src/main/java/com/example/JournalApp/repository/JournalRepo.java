package com.example.JournalApp.repository;

import com.example.JournalApp.model.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<Journal, ObjectId> {
}
