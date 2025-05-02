package com.example.JournalApp.repository;

import com.example.JournalApp.model.CacheConfig;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CacheRepo extends MongoRepository<CacheConfig, ObjectId> {
}
