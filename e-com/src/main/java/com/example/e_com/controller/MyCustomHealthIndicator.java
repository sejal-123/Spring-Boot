package com.example.e_com.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean value = checkHealth();
        if (value) {
            return Health.up().withDetail("DB_SERVICE", "Database service is up and running").build();
        }
        return Health.down().withDetail("DB_SERVICE", "Database service is down").build();
    }

    public boolean checkHealth() {
        // custom logic
        return true;
    }
}
