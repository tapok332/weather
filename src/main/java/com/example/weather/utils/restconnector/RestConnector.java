package com.example.weather.utils.restconnector;

import com.example.weather.utils.exception.WeatherErrorCode;
import com.example.weather.utils.exception.WeatherException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@Slf4j
@RequiredArgsConstructor
public class RestConnector {

    private final RestTemplate restTemplate;

    public <T> T callGet(URI uri, Class<T> responseType) {
        try {
            var responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, responseType);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                log.error("Received non-success status code: {}", responseEntity.getStatusCode());
                throw new RuntimeException("Received non-success status code: " + responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            throw WeatherException.error(WeatherErrorCode.CONNECTION_ERROR, e);
        }
    }

    public <T> T callGet(URI uri, ParameterizedTypeReference<T> responseType) {
        try {
            var responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, null, responseType);
            return getResponse(responseEntity);
        } catch (HttpClientErrorException e) {
            throw WeatherException.error(WeatherErrorCode.CONNECTION_ERROR, e);
        }
    }

    private static <T> T getResponse(ResponseEntity<T> responseEntity) {
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            log.error("Received non-success status code: {}", responseEntity.getStatusCode());
            throw new RuntimeException("Received non-success status code: " + responseEntity.getStatusCode());
        }
    }
}
