package com.example.weather.basicfunctionality;

import com.example.weather.utils.weather.CurrentWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basic")
public class BasicWeatherController {

    private final BasicWeatherService basicWeatherService;

    @GetMapping("/{city}")
    public CurrentWeather getWeatherByCity(@PathVariable String city,
                                           @RequestHeader(name = HttpHeaders.ACCEPT_LANGUAGE, defaultValue = "en") String language) {
        return basicWeatherService.getWeatherByCity(city, language);
    }
}
