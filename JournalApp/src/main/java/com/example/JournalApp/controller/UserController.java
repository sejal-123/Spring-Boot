package com.example.JournalApp.controller;

import com.example.JournalApp.api.Weather;
import com.example.JournalApp.model.User;
import com.example.JournalApp.service.UserService;
import com.example.JournalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        if (user1 != null) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteByUserName(@PathVariable String username) {
        User user = userService.findByUserName(username);
        if (user != null){
            userService.deleteByUserName(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user1 = userService.findByUserName(username);
        if (user1 != null) {
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<Boolean> updateUserByUsername(@RequestBody User user, @PathVariable String username) {
        User user1 = userService.findByUserName(username);
        if (user1 != null) {
            user1.setPassword(user.getPassword());
            userService.updateUser(user1);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/weather")
    public ResponseEntity<String> getWeatherDetails(@RequestParam String city) {
        Weather weather = weatherService.getWeather(city);
        if (weather != null) {
            String result = "Hi, weather is " + weather.getCurrent().getTemperature() + " in " + city;
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_GATEWAY);
    }


}
