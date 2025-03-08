package com.example.SimpleWebApplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "Welcome to homepage..";
    }

    @RequestMapping("/about")
    public String about() {
        return "You are on about page..";
    }


}
