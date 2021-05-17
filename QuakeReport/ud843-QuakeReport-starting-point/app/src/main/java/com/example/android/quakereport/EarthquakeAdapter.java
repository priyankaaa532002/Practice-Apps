package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {



    ArrayList<Earthquake> earthquakes;
    public EarthquakeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Earthquake> objects) {
        super(context, resource, objects);
        this.earthquakes = objects;
    }

    @Nullable
    @Override
    public Earthquake getItem(int position) {
        return earthquakes.get(position);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double mag) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(mag);
    }

    private int getMagnitudeColor(double mag){
        int magFloor = (int) Math.floor(mag);
        int magColor;
        switch (magFloor){
            case 0:
            case 1:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magColor = ContextCompat.getColor(getContext(),R.color.magnitude10plus);
                break;
        }
        return magColor;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        TextView mag = (TextView) convertView.findViewById(R.id.mag);
        double magnitude = getItem(position).getMagnitude();
        String formattedMag = formatMagnitude(magnitude);
        mag.setText(formattedMag);


//        TextView place = (TextView) convertView.findViewById(R.id.place);
//        place.setText(getItem(position).getPlace());
        Date date = new Date(getItem(position).getTime());
        String formattedDate = formatDate(date);
        String formattedTime = formatTime(date);

        TextView dateText = (TextView) convertView.findViewById(R.id.date);
        dateText.setText(formattedDate);

        TextView timeText = (TextView) convertView.findViewById(R.id.time);
        timeText.setText(formattedTime);


        String location = getItem(position).getPlace();
        String offset;
        String primary;

        if(location.contains("of ")) {
            String[] parts = location.split("of ");
            offset = parts[0] + "of";
            primary = parts[1];

        } else {
            offset = "Near the";
            primary = location;
        }

        TextView offsetText = (TextView) convertView.findViewById(R.id.offset);
        offsetText.setText(offset);

        TextView primaryText = (TextView) convertView.findViewById(R.id.primary);
        primaryText.setText(primary);

        GradientDrawable magnitudeCircle = (GradientDrawable)mag.getBackground();
        int magnitudeColor = getMagnitudeColor(getItem(position).getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        return convertView;

    }
}
