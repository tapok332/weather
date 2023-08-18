package com.example.weather.utils.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WeatherRestExceptionHandler {

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<ErrorDetails> petsException(WeatherException e) {
        log.error("WeatherException", e);
        return ResponseEntity
                .status(e.getErrorDetails().getHttpStatus().value())
                .body(e.getErrorDetails());
    }
}
