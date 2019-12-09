package com.bootcamp.aa.southworst.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    private Map<String, Integer> uriVariables(int query) {
        var variables = new HashMap<String, Integer>();
        variables.put("query", query);
        return variables;
    }

}
