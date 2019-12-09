package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/")
    public String getAllFlights() {
        return flightRepository.getFlightsByDateAndLocations("2020-12-10", "DWW", "ORD");
    }

    //        @GetMapping(path="/all")
//        public @ResponseBody Iterable<Flight> getAllFlights() {
//            return ***Repository.findAll();
//        }
}
