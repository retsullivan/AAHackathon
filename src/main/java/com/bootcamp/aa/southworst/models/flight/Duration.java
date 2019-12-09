package com.bootcamp.aa.southworst.models.flight;

public class Duration {
    private String locale;
    private int hours;
    private int minutes;

    public Duration(String locale, int hours, int minutes) {
        this.locale = locale;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Duration() {

    }

    public String getLocale() {
        return locale;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
