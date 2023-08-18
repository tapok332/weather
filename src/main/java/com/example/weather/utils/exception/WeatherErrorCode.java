package com.example.weather.utils.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Locale;
import java.util.ResourceBundle;

@AllArgsConstructor
public enum WeatherErrorCode {

    UNKNOWN_ERROR(HttpStatus.MULTI_STATUS, "unknown_error", "%s"),
    CONNECTION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "connection_error", "%s");

    private final HttpStatus httpStatus;
    private final String message;
    private final String description;


    public String getMessage() {
        return message;
    }

    public String getMessage(String language) {
        return ResourceBundle.getBundle("text", Locale.forLanguageTag(language),
                        ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_PROPERTIES))
                .getString(message);
    }

    public String getDescription() {
        return description;
    }

    public String getDescription(Object... params) {
        if (params != null) {
            return String.format(description, params);
        }
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
