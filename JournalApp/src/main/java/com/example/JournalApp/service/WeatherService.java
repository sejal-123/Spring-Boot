package com.example.JournalApp.service;

import com.example.JournalApp.api.Weather;
import com.example.JournalApp.cache.AppCache;
import com.example.JournalApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String API_KEY;

    private String API_URL="https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserService userService;

    @Autowired
    private AppCache appCache;

    public Weather getWeather(String city) {
        String finalAPI=appCache.cacheMap.get(AppCache.keys.WEATHER_API.toString()).replace("<apiKey>", API_KEY).replace("<city>", city);
        return restTemplate.exchange(finalAPI, HttpMethod.GET, null, Weather.class).getBody();
    }
}
