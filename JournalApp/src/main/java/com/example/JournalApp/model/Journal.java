package com.example.JournalApp.model;

public class Journal {
    private long id;
    private String title;
    private String summary;

    public Journal(long id, String title, String summary) {
        this.id = id;
        this.title = title;
        this.summary = summary;
    }

    public Journal() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
