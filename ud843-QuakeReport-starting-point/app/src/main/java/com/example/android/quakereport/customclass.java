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


    public customclass(final double magnitude, final String place, final long time){
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;

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
