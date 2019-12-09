package com.bootcamp.aa.southworst;

import com.bootcamp.aa.southworst.client.FlightsClient;
import com.bootcamp.aa.southworst.models.ItineraryInfo;
import com.bootcamp.aa.southworst.models.Segment;
import com.bootcamp.aa.southworst.models.flight.FlightInfo;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        return new ItineraryInfo(segments, totalTime);
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
        List<FlightInfo> startingFlights= getFlightByOrigin(origin, data);

        for (FlightInfo flight: startingFlights) {
            getFlightByOrigin(flight.getOrigin().getCode(), data);
        }
        var segments = Arrays.asList(data, Segment[].class);
        return new ItineraryInfo(new ArrayList<Segment>(), 1700);
    }

    private List<FlightInfo> getFlightByOrigin(String origin, List<FlightInfo> data) {
        return data.stream().filter(f -> f.getOrigin().equals(origin))
            .collect(Collectors.toList());
    }

    private Date convertToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        Date flightDate = format.parse(date);
        return flightDate;
    }

    public List<FlightInfo> getWorstTrip(String date, String origin, String destination) throws ParseException {

        String travelDate = date;
        Date flightDate = convertToDate(date);
        List<FlightInfo> allFlights = getStartingFlights(date, origin);
        List<FlightInfo> testItinerary = new ArrayList<>();

        List<List<FlightInfo>> flightsWithCorrectDestination = new ArrayList<>();

        for (FlightInfo flight:allFlights){
            List<FlightInfo> itinerary = getAllIterations(travelDate, flightDate, origin,testItinerary);
            if ((itinerary.size() - 1>0) && itinerary.get(itinerary.size() - 1).getDestination().getCode().equalsIgnoreCase(destination)) {
                flightsWithCorrectDestination.add(itinerary);
            }
        }
        return getWorstTrip(flightsWithCorrectDestination);
    }


    private List<FlightInfo> getAllIterations(String travelDate, Date date, String origin, List<FlightInfo> itinerary) throws ParseException {
        var allFlights = getStartingFlights(travelDate,origin);
        Date compareTravelDate = convertToDate(travelDate);
        var previousArrivalTime = date;
        List<FlightInfo> itineraryList = itinerary;

        for (FlightInfo flight : allFlights) {
            if (flight.getDepartureTime().after(previousArrivalTime) &&
                    !flight.getArrivalTime().after(compareTravelDate)) {
                itineraryList.add(flight);
                previousArrivalTime = flight.getArrivalTime();
                getAllIterations(travelDate,previousArrivalTime,origin, itinerary);
            }
        }
        return itineraryList;
    }

    private List<FlightInfo> getWorstTrip(List<List<FlightInfo>> flightsWithCorrectDestination){
        Integer highestTravelTimeIndex=0;
        for (List<FlightInfo> itinerary :flightsWithCorrectDestination){
            Integer totalTravelTime = 0;
            for(FlightInfo flight:itinerary){
                totalTravelTime += flight.getDuration().getTotal();
            }
            if(highestTravelTimeIndex<totalTravelTime){
                highestTravelTimeIndex = totalTravelTime;
            }
        }
        return flightsWithCorrectDestination.get(highestTravelTimeIndex);
    }


}
