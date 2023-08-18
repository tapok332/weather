package com.example.weather.utils.exception;

import lombok.Getter;

@Getter
public class WeatherException extends RuntimeException {

    private final ErrorDetails errorDetails;

    private WeatherException(ErrorDetails errorDetails, Exception cause) {
        super(createMessage(errorDetails), cause);
        this.errorDetails = errorDetails;
    }

    private WeatherException(ErrorDetails errorDetails) {
        this(errorDetails, null);
    }

    public static WeatherException error(WeatherErrorCode errorCode) {
        return new WeatherException(ErrorDetails.of(errorCode));
    }

    public static WeatherException error(WeatherErrorCode errorCode, Exception cause) {
        return new WeatherException(ErrorDetails.ofWithDescription(errorCode, cause.getMessage()), cause);
    }

    public static WeatherException errorWithDescription(WeatherErrorCode errorCode, Object... description) {
        return new WeatherException(ErrorDetails.ofWithDescription(errorCode, description));
    }

    public static WeatherException error(WeatherErrorCode errorCode, String language, Object... description) {
        return new WeatherException(ErrorDetails.of(errorCode, language, description));
    }

    private static String createMessage(ErrorDetails errorDetails) {
        if (errorDetails != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(errorDetails.getMessage()).append(": ");
            if (errorDetails.getDescription() != null && errorDetails.getDescription().equals("%s")) {
                stringBuilder.append(errorDetails.getDescription());
            } else {
                stringBuilder.append("no description");
            }
            return stringBuilder.toString();
        }
        return "";
    }
}
