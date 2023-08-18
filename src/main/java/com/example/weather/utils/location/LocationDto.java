package com.example.weather.utils.location;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class LocationDto {

    private String name;
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;
}
