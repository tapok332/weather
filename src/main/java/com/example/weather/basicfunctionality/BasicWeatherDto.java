package com.example.weather.basicfunctionality;

import com.example.weather.utils.forecast.DailyForecast;
import com.example.weather.utils.forecast.HourlyForecast;
import com.example.weather.utils.forecast.MinuteForecast;
import com.example.weather.utils.weather.CurrentWeather;
import com.example.weather.utils.weatheralert.Alert;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasicWeatherDto {

    private double lat;
    private double lon;
    private String timezone;
    private int timezoneOffset;
    private CurrentWeather current;
    private List<MinuteForecast> minutely;
    private List<HourlyForecast> hourly;
    private List<DailyForecast> daily;
    private List<Alert> alerts;

}
