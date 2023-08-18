package com.example.weather.utils.weather;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrentWeather {
    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feelsLike;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double uvi;
    private int clouds;
    private int visibility;
    private double wind_speed;
    private int windDeg;
    private double windGust;
    private List<Weather> weather;
}
