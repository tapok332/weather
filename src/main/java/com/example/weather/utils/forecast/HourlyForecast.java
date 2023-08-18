package com.example.weather.utils.forecast;

import com.example.weather.utils.weather.Weather;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HourlyForecast {
    private long dt;
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
    private double pop;
}
