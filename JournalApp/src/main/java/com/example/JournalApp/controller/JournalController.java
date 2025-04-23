package com.example.JournalApp.controller;

import com.example.JournalApp.model.Journal;
import com.example.JournalApp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("")
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> journals = journalService.getAll();
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @PostMapping("")
    public String createEntry(@RequestBody Journal journal) {
//        if (journalMap.get(journal.getId()) == null) {
//            journalMap.put(journal.getId(), journal);
//            return "Success";
//        } else {
//            return "Record already exists";
//        }
        return null;
    }

    @GetMapping("/{id}")
    public Journal getJournal(@PathVariable long id) {
        return null;
    }

    @PutMapping("/{id}")
    public String updateJournal(@PathVariable long id, @RequestBody Journal journal) {
//        if (journalMap.get(id) != null) {
//            journalMap.put(id, journal);
//            return "Updated";
//        } else {
//            return "Record doesn't exists";
//        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable long id) {
//        if (journalMap.get(id) != null) {
//            journalMap.remove(id);
//            return "Deleted";
//        } else {
//            return "Record doesn't exists";
//        }
        return null;
    }

}
