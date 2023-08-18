package com.example.weather.utils.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ErrorDetails {

    private final HttpStatus httpStatus;
    private final String message;
    private final String description;

    public static ErrorDetails of(WeatherErrorCode errorCode) {
        return new ErrorDetails(errorCode.getHttpStatus(), errorCode.getMessage("en"), errorCode.getDescription());
    }

    public static ErrorDetails ofWithMessage(WeatherErrorCode errorCode, String message) {
        return new ErrorDetails(errorCode.getHttpStatus(), errorCode.getMessage(message), errorCode.getDescription());
    }

    public static ErrorDetails ofWithDescription(WeatherErrorCode errorCode, Object... description) {
        return new ErrorDetails(errorCode.getHttpStatus(), errorCode.getMessage("en"), errorCode.getDescription(description));
    }

    public static ErrorDetails of(WeatherErrorCode errorCode, String language, Object... description) {
        return new ErrorDetails(errorCode.getHttpStatus(), errorCode.getMessage(language), errorCode.getDescription(description));
    }
}
