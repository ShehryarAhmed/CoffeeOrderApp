package com.example.android.quakereport;

import java.sql.Time;
import java.util.Date;

/**
 * Created by android on 9/21/2016.
 */
public class customclass  {

    private double magnitude;

    private String place;

    private String date;

    private Time time;

    public customclass(final double magnitude, final String place, final String date){
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;

    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }


}
