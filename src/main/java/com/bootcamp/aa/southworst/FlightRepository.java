package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import com.bootcamp.aa.southworst.models.FlightData;
import com.bootcamp.aa.southworst.models.Segment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepository {

    FlightsClient flightsClient;

    public FlightRepository(FlightsClient flightsClient) {
        this.flightsClient = flightsClient;
    }

    public FlightData getFlightsByDateAndLocations(String date, String Origin, String Destination) {

        var data = flightsClient.getFlights("2020-12-10");

        return new FlightData(new ArrayList<Segment>(), 1700);
    }

}
