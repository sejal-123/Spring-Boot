package com.example.JournalApp.service;

import com.example.JournalApp.model.Journal;
import com.example.JournalApp.repository.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepo journalRepo;

    public Journal createJournal(Journal journal) {
        return journalRepo.save(journal);
    }

    public List<Journal> getAll() {
        return journalRepo.findAll();
    }
}
