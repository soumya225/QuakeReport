package com.example.android.quakereport;

public class Earthquake {
    private String magnitude;
    private String city;
    private long time; //in milliseconds

    public Earthquake(String magnitude, String city, long time) {
        this.magnitude = magnitude;
        this.city = city;
        this.time = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }

    public long getTime() {
        return time;
    }
}
