package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import org.springframework.stereotype.Repository;

@Repository
public class FlightRepository {

    FlightsClient flightsClient;

    public FlightRepository(FlightsClient flightsClient) {
        this.flightsClient = flightsClient;
    }

    public String getFlightsByDateAndLocations(String date, String Origin, String Destination) {
        return flightsClient.getFlights("2020-12-10");
    }

}
