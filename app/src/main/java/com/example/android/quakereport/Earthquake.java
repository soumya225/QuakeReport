package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long time; //in milliseconds

    public Earthquake(double magnitude, String city, long time) {
        this.magnitude = magnitude;
        this.location = city;
        this.time = time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }
}
