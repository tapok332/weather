package com.example.weather.utils.forecast;

import com.example.weather.utils.temperature.Temperature;
import com.example.weather.utils.weather.Weather;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DailyForecast {
    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private double moonPhase;
    private String summary;
    private Temperature temp;
    private Temperature feelsLike;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double windSpeed;
    private int windDeg;
    private double windGust;
    private List<Weather> weather;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;
}
