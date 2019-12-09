package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import com.bootcamp.aa.southworst.models.FlightInfo;
import com.bootcamp.aa.southworst.models.Segment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class FlightRepository {

    FlightsClient flightsClient;
    private List<Segment> segments;
    private FlightInfo flightInfo;

    public FlightRepository(FlightsClient flightsClient) {

        this.flightsClient = flightsClient;
    }

    public FlightInfo getDummyData(String date, String Origin, String Destination) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment("DFW", "ORD", 100, 1, 1999, new Date(), new Date()));
        int totalTime = 100;
        return new FlightInfo(segments, totalTime);
    }

    public FlightInfo getFlightsByDateAndLocations(String date, String Origin, String Destination) {

        var data = flightsClient.getFlights("2020-12-10");

        return new FlightInfo(new ArrayList<Segment>(), 1700);
    }



}
