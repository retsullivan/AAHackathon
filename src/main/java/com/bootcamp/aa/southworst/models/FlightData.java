package com.bootcamp.aa.southworst.models;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class FlightData {

    private List<Segment> segments;
    private int totalTime;

    public FlightData(List<Segment> segments, int totalTime) {
        this.segments = segments;
        this.totalTime = totalTime;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
