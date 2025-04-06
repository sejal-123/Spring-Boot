package com.example.yaml_and_command_line_args;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, Good evening!";
    }
}
