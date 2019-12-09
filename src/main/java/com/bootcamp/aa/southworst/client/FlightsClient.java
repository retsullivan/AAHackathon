package com.bootcamp.aa.southworst.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightsClient {
    private final RestTemplate restTemplate;

    public FlightsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFlights(String date) {
        return restTemplate.getForObject("https://flight-engine.herokuapp.com/flights?date=" + date,
                String.class);
    }

}
