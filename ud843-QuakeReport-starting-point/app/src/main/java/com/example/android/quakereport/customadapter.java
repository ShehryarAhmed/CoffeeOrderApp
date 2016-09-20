package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 9/21/2016.
 */
public class customadapter extends ArrayAdapter<customclass>  {

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

        TextView place = (TextView) listitemview.findViewById(R.id.place);

        place.setText(""+currentlist.getPlace());

        TextView time = (TextView) listitemview.findViewById(R.id.time);

        time.setText(""+currentlist.getDate());

        return listitemview;

    }
}
