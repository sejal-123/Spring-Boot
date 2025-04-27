package com.example.JournalApp.service;

import com.example.JournalApp.model.Journal;
import com.example.JournalApp.model.User;
import com.example.JournalApp.repository.JournalRepo;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepo journalRepo;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(JournalService.class);

    public Journal createJournal(Journal journal) {
        return journalRepo.save(journal);
    }

    public List<Journal> getAll() {
        return journalRepo.findAll();
    }

    public Optional<Journal> findById(ObjectId id) {
        return journalRepo.findById(id);
    }

    @Transactional
    public void saveEntry(Journal journal, String username) {
        try {
            User user = userService.findByUserName(username);
            journal.setDate(LocalDateTime.now());
            Journal saved = journalRepo.save(journal);
            user.getJournalEntries().add(saved);
            userService.updateUser(null);
        } catch(Exception e) {
            logger.info("Error occurred");
            logger.error("Error occurred");
            logger.warn("Error occurred");
            throw new RuntimeException("An error occured while saving entry", e);
        }
    }

    public Journal updateEntry(Journal entry) {
        return journalRepo.save(entry);
    }

    @Transactional
    public boolean delete(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(username);
            removed = user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if (removed) {
                userService.updateUser(user);
                journalRepo.deleteById(id);
            }
        } catch(Exception e) {
            throw new RuntimeException("An error occured while removing", e);
        }
        return removed;
    }
}
