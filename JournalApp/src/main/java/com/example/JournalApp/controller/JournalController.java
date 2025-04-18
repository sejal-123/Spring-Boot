package com.example.JournalApp.controller;

import com.example.JournalApp.model.Journal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {

    Map<Long, Journal> journalMap = new HashMap<>();

    @GetMapping("")
    public List<Journal> getAllJournals() {
        return new ArrayList<>(journalMap.values());
    }

    @PostMapping("")
    public String createEntry(@RequestBody Journal journal) {
        if (journalMap.get(journal.getId()) == null) {
            journalMap.put(journal.getId(), journal);
            return "Success";
        } else {
            return "Record already exists";
        }
    }

    @GetMapping("/{id}")
    public Journal getJournal(@PathVariable long id) {
        return journalMap.get(id);
    }

    @PutMapping("/{id}")
    public String updateJournal(@PathVariable long id, @RequestBody Journal journal) {
        if (journalMap.get(id) != null) {
            journalMap.put(id, journal);
            return "Updated";
        } else {
            return "Record doesn't exists";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable long id) {
        if (journalMap.get(id) != null) {
            journalMap.remove(id);
            return "Deleted";
        } else {
            return "Record doesn't exists";
        }
    }

}
