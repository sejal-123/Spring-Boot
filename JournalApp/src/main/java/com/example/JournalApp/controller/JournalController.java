package com.example.JournalApp.controller;

import com.example.JournalApp.model.Journal;
import com.example.JournalApp.model.User;
import com.example.JournalApp.service.JournalService;
import com.example.JournalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<List<Journal>> getAllJournals(@PathVariable String username) {
        User user = userService.findByUserName(username);
        if (user != null) {
            List<Journal> journals = user.getJournalEntries();
            return new ResponseEntity<>(journals, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{username}")
    public ResponseEntity<Journal> createEntry(@RequestBody Journal journal, @PathVariable String username) {
        try {
            User user = userService.findByUserName(username);
            if (user != null) {
                journalService.saveEntry(journal, username);
                return new ResponseEntity<>(journal, HttpStatus.CREATED);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @GetMapping("/{username}/{id}")
    public ResponseEntity<?> getJournal(@PathVariable ObjectId id, @PathVariable String username) {
        User user = userService.findByUserName(username);
        if (user != null) {
            List<Journal> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
            if(!collect.isEmpty()) {
                Optional<Journal> journal = journalService.findById(id);
                if (journal.isPresent()) {
                    return new ResponseEntity<>(journal, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{username}/{id}")
    public ResponseEntity<?> updateJournal(@PathVariable String username, @PathVariable ObjectId id, @RequestBody Journal journal) {
        try {
            User user = userService.findByUserName(username);
            if (user != null) {
                List<Journal> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
                if(!collect.isEmpty()) {
                    Optional<Journal> old = journalService.findById(id);
                    if (old.isPresent()) {
                        Journal entry = old.get();
                        entry.setTitle(journal.getTitle() != null && !journal.getTitle().equals("") ? journal.getTitle() : entry.getTitle());
                        entry.setSummary(journal.getSummary() != null && !journal.getSummary().equals("") ? journal.getSummary() : entry.getSummary());
                        journalService.updateEntry(entry);
                        return new ResponseEntity<>(entry, HttpStatus.OK);
                    }
                }
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable String username, @PathVariable ObjectId id) {
        User user = userService.findByUserName(username);
        if (user != null) {
            boolean removed = journalService.delete(id, username);
            if (removed) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

}
