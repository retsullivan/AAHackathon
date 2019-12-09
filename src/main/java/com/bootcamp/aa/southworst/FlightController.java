package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.models.FlightInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flights")
    public FlightInfo getAllFlights(@RequestParam String date, @RequestParam String origin, @RequestParam String destination) {
        return flightRepository.getDummyData("2020-12-10", "DWW", "ORD");
    }

    //        @GetMapping(path="/all")
//        public @ResponseBody Iterable<Flight> getAllFlights() {
//            return ***Repository.findAll();
//        }
}
