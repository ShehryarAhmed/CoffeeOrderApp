package com.example.android.quakereport;

import java.sql.Time;
import java.util.Date;

/**
 * Created by android on 9/21/2016.
 */
public class customclass  {

    private double magnitude;

    private String place;

    private long time;

private String url;
    public customclass(final double magnitude, final String place, final long time, final String URL){
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.url = URL;
    }

    public String getUrl() {
        return url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }





}
