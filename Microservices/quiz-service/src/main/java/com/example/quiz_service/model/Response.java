package com.example.quiz_service.model;

public class Response {

    private int id;
    private String option;

    public Response(String option, int id) {
        this.option = option;
        this.id = id;
    }

    public Response() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
