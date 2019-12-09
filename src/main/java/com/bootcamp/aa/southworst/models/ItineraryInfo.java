package com.bootcamp.aa.southworst.models;

import java.util.List;

public class ItineraryInfo {

    private List<Segment> segments;
    private int totalTime;

    public ItineraryInfo(List<Segment> segments, int totalTime) {
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
