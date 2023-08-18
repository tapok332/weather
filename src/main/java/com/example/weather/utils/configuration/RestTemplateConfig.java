package com.example.weather.utils.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@Slf4j
public class RestTemplateConfig {

    @Bean(name = "appRestClient")
    public RestTemplate getRestClient() {
        RestTemplate restClient = new RestTemplate();

        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {
            log.debug("Intercepting...");
            return execution.execute(request, body);
        }));

        return restClient;
    }
}
