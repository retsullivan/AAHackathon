package com.bootcamp.aa.southworst.models;

import java.util.List;

public class ItineraryInfo {

    private List<Segment> segments;
    private int totalTime;
    private String recordLocator;

    public ItineraryInfo(List<Segment> segments, int totalTime, String recordLocator) {
        this.segments = segments;
        this.totalTime = totalTime;
        this.recordLocator = recordLocator;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public String getRecordLocator() {
        return recordLocator;
    }
}
