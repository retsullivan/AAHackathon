package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    FlightsClient flightsClient;

    public FlightController(FlightsClient flightsClient) {
        this.flightsClient = flightsClient;
    }

    @GetMapping("/")
    public String getAllFlights() {
        return flightsClient.getFlights("2020-12-10");
    }

    //        @GetMapping(path="/all")
//        public @ResponseBody Iterable<Flight> getAllFlights() {
//            return ***Repository.findAll();
//        }
}
