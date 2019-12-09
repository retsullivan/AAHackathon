package com.bootcamp.aa.southworst.client;

import com.bootcamp.aa.southworst.models.flight.FlightInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightsClient {
    private final RestTemplate restTemplate;

    public FlightsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<FlightInfo> getFlights(String date) {
        return Arrays.asList(restTemplate.getForObject("https://flight-engine.herokuapp.com/flights?date=" + date,
                FlightInfo[].class));
    }

}
