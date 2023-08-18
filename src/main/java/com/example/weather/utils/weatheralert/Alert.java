package com.example.weather.utils.weatheralert;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Alert {
    private String sender_name;
    private String event;
    private long start;
    private long end;
    private String description;
    private List<String> tags;
}
