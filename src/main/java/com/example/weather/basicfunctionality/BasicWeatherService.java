package com.example.weather.basicfunctionality;

import com.example.weather.utils.location.LocationDto;
import com.example.weather.utils.restconnector.RestConnector;
import com.example.weather.utils.weather.CurrentWeather;
import com.example.weather.utils.weatherapiproperties.WeatherProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasicWeatherService {

    private final RestConnector restConnector;
    private final WeatherProperties weatherProperties;

    public CurrentWeather getWeatherByCity(String city, String language) {
        var location = restConnector.callGet(weatherProperties.getLocationUrl(city),
                new ParameterizedTypeReference<List<LocationDto>>() {
                });
        return restConnector.callGet(weatherProperties.getBasicUrl(location.get(0).getLat(), location.get(0).getLon()),
                BasicWeatherDto.class).getCurrent();
    }
}
