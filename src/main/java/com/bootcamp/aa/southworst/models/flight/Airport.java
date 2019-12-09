package com.bootcamp.aa.southworst.models.flight;

public class Airport {
    private String code;
    private String city;

    public Airport(String code, String city) {
        this.code = code;
        this.city = city;
    }

    public Airport() {

    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }
}
