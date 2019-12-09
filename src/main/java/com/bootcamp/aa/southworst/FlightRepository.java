package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import com.bootcamp.aa.southworst.models.ItineraryInfo;
import com.bootcamp.aa.southworst.models.Segment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FlightRepository {

    FlightsClient flightsClient;
    private List<Segment> segments;
    private ItineraryInfo itineraryInfo;

    public FlightRepository(FlightsClient flightsClient) {

        this.flightsClient = flightsClient;
    }

    public ItineraryInfo getDummyData(String date, String Origin, String Destination) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment("DFW", "ORD", 100, 1, 1999, new Date(), new Date()));
        int totalTime = 100;
        return new ItineraryInfo(segments, totalTime);
    }

    public ItineraryInfo getFlightsByDateAndLocations(String date, String Origin, String Destination) {

        var data = flightsClient.getFlights("2020-12-10");

        return new ItineraryInfo(new ArrayList<Segment>(), 1700);
    }



}
