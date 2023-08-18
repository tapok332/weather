package com.example.weather.utils.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinuteForecast {
    private long dt;
    private double precipitation;
}
