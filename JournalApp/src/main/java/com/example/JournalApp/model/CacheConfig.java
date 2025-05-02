package com.example.JournalApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config_journal_cache")
@Data
@NoArgsConstructor
public class CacheConfig {
    private String key;
    private String value;
}
