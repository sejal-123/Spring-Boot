package com.example.JournalApp.cache;

import com.example.JournalApp.model.CacheConfig;
import com.example.JournalApp.repository.CacheRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum  keys {
        WEATHER_API
    }

    public Map<String, String> cacheMap;

    @Autowired
    private CacheRepo cacheRepo;

    @PostConstruct
    public void init() {
        List<CacheConfig> caches = cacheRepo.findAll();
        cacheMap = new HashMap<>();
        for (CacheConfig c: caches) {
            cacheMap.put(c.getKey(), c.getValue());
        }
    }
}
