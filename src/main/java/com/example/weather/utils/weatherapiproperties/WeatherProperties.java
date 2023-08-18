package com.example.weather.utils.weatherapiproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherProperties {

    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.weather-url}")
    private String weatherUrl;
    @Value("${weather.api.location-url}")
    private String locationUrl;

    public URI getBasicUrl(double latitude, double longitude) {
        return UriComponentsBuilder.fromHttpUrl(weatherUrl)
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("appid", apiKey)
                .build().toUri();
    }

    public URI getLocationUrl(String city) {
        return UriComponentsBuilder.fromHttpUrl(locationUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .build().toUri();
    }
}
