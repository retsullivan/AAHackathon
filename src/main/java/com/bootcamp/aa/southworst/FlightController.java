package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.cache.ItineraryCache;
import com.bootcamp.aa.southworst.models.ItineraryInfo;
import com.bootcamp.aa.southworst.models.flight.FlightInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights-dummy")
    public ItineraryInfo getDummyFlights(@RequestParam String date, @RequestParam String origin, @RequestParam String destination) {
        return flightRepository.getDummyData("2020-12-10", "DWW", "ORD");
    }

    @GetMapping("/flights")
    public ItineraryInfo getAllFlights(@RequestParam String date, @RequestParam String origin, @RequestParam String destination) {
        ItineraryInfo itineraryInfo = flightRepository.getFlightsByDateAndLocations("2020-12-10", "DFW", "ORD");
        ItineraryCache.addItemToCache(itineraryInfo);
        return itineraryInfo;
    }

    @GetMapping("/starting-flights")
    public List<FlightInfo> getStartingFlights(@RequestParam String date, @RequestParam String origin) {
        return flightRepository.getStartingFlights(date, origin);
    }

    @GetMapping("/ending-flights")
    public List<FlightInfo> getEndingFlights(@RequestParam String date, @RequestParam String destination) {
        return flightRepository.getEndingFlights(date, destination);
    }
}
