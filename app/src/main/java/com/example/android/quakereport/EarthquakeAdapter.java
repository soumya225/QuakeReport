package com.example.android.quakereport;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
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

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        cityTextView.setText(currentEarthquake.getCity());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentEarthquake.getTime());
        String formattedDate = c.getDisplayName(c.MONTH, Calendar.SHORT, Locale.ENGLISH) + " " + c.get(c.DAY_OF_MONTH) + ", " + c.get(c.YEAR);
        dateTextView.setText(formattedDate);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
