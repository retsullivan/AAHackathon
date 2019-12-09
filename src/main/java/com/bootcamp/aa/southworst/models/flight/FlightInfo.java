package com.bootcamp.aa.southworst.models.flight;

import java.util.Date;

public class FlightInfo {

    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private int distance;
    private Duration duration;
    private Date departureTime;
    private Date arrivalTime;

    public FlightInfo() {

    }

    public FlightInfo(String flightNumber, Airport origin, Airport destination, int distance, Duration duration, Date departureTime, Date arrivalTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.duration = duration;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
}
