package com.bootcamp.aa.southworst.models;

import java.util.Date;

public class Segment {
    private String origin;
    private String destination;
    private int travelTime; // minute
    private int index;
    private int flightNumber;
    private Date departureTime;
    private Date arrivalTime;

    public Segment(String origin, String destination, int travelTime, int index, int flightNumber, Date departureTime, Date arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.travelTime = travelTime;
        this.index = index;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public int getIndex() {
        return index;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
}
