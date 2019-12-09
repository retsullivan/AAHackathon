package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.cache.ItineraryCache;
import com.bootcamp.aa.southworst.client.FlightsClient;
import com.bootcamp.aa.southworst.models.ItineraryInfo;
import com.bootcamp.aa.southworst.models.Segment;
import com.bootcamp.aa.southworst.models.flight.FlightInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FlightRepository {

    FlightsClient flightsClient;
    private List<Segment> segments;
    private ItineraryInfo itineraryInfo;

    public FlightRepository(FlightsClient flightsClient) {

        this.flightsClient = flightsClient;
    }

    public ItineraryInfo getDummyData(String date, String origin, String destination) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment("DFW", "ORD", 100, 1, 1999, new Date(), new Date()));
        int totalTime = 100;
        return new ItineraryInfo(segments, totalTime, ItineraryCache.getRecordLocator());
    }

    public List<FlightInfo> getStartingFlights(String date, String origin) {
        var data = flightsClient.getFlights(date).stream().filter(f -> f.getOrigin().getCode().equals(origin))
                .collect(Collectors.toList());
        return data;

    }

    public List<FlightInfo> getEndingFlights(String date, String destination) {
        var data2 = flightsClient.getFlights(date).stream().filter(d -> d.getDestination().getCode().equals(destination))
                .collect(Collectors.toList());
        return data2;
    }

    public ItineraryInfo getFlightsByDateAndLocations(String date, String origin, String destination) {

        var data = flightsClient.getFlights(date);
        data.stream().filter(f -> f.getOrigin().equals(origin))
                .collect(Collectors.toList());

        var segments = Arrays.asList(data,
                Segment[].class);

        return new ItineraryInfo(new ArrayList<Segment>(), 1700, ItineraryCache.getRecordLocator());
    }


}
