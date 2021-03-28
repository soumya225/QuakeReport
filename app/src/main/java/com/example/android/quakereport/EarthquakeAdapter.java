package com.example.android.quakereport;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        String magnitude = String.format("%.1f",currentEarthquake.getMagnitude());
        magnitudeTextView.setText(magnitude);


        String location = currentEarthquake.getLocation();
        String offset = "Near";
        if(location.contains("of")){
            String[] parts = location.split("(?=of)");
            offset = parts[0];
            location = parts[1];
        }

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(location);

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset);
        offsetTextView.setText(offset);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentEarthquake.getTime());
        String formattedDate = c.getDisplayName(c.MONTH, Calendar.SHORT, Locale.ENGLISH) + " " + c.get(c.DAY_OF_MONTH) + ", " + c.get(c.YEAR);
        dateTextView.setText(formattedDate);

        return listItemView;
    }
}
