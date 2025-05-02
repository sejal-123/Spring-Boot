package com.example.JournalApp.service;

import com.example.JournalApp.cache.AppCache;
import com.example.JournalApp.model.Journal;
import com.example.JournalApp.model.User;
import com.example.JournalApp.repository.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSchedulerService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImpl impl;

    @Autowired
    private SentimentService sentimentService;

    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 0 9 * * SUN")
    public void scheduleMailwithSA() {
        List<User> users = impl.getUserSA();
        for (User user: users) {
            List<Journal> journalEntries = user.getJournalEntries();
            List<Journal> filteredEntries = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).collect(Collectors.toList());
//            String entry = String.join(filteredEntries, " ");
            String sentiment = sentimentService.getSentiment();
            emailService.sendEmail(user.getEmail(), "Sentiment analysis", "Your sentiment for last 7 days is " + sentiment);
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void refreshCache() {
        appCache.init();
    }
}
