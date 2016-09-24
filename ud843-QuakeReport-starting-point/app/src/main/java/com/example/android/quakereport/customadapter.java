package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;


/**
 * Created by android on 9/21/2016.
 */
public class customadapter extends ArrayAdapter<customclass>  {

    private static final String LOCATION_SEPARATER = " of ";

    private String primaryLocation;

    private String locationOffset;

    public customadapter(Activity activity, ArrayList<customclass> arrayList){
        super(activity,0,arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview = convertView;

        if(listitemview == null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        customclass currentlist = getItem(position);

        TextView magnitude = (TextView) listitemview.findViewById(R.id.magnitudeview);

        magnitude.setText(""+currentlist.getMagnitude());

        String OrignalLocation = currentlist.getPlace();

        split(OrignalLocation,LOCATION_SEPARATER);


        TextView near = (TextView) listitemview.findViewById(R.id.near);

        near.setText(locationOffset);

        TextView place = (TextView) listitemview.findViewById(R.id.place);

        place.setText(primaryLocation);

        TextView date = (TextView) listitemview.findViewById(R.id.date);

        Date dateobject = new Date(currentlist.getTime());

        String formatteddate = formatDate(dateobject);

        date.setText(formatteddate);

        TextView time = (TextView) listitemview.findViewById(R.id.time);

        String timeformate = formatTime(dateobject);

        time.setText(timeformate);

        return listitemview;

    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private void split(String Orignallocation, final String separater){
        if(Orignallocation.contains(separater)) {
            String nowsplit[] = Orignallocation.split(separater);
            locationOffset = nowsplit[0] += separater;
            primaryLocation = nowsplit[1];
        }
        else {
            locationOffset = getContext().getString(R.string.Near_the);
            primaryLocation = Orignallocation;
        }
    }
}
