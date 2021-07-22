package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Song> al;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> al) {
        super(context, resource, al);

        this.context = context;
        this.resource = resource;
        this.al = al;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        TextView tvpurple = rowView.findViewById(R.id.Title);
        TextView tvplain = rowView.findViewById(R.id.year);
        TextView tvred = rowView.findViewById(R.id.star);
        TextView tvblue = rowView.findViewById(R.id.singer);
        Song currentVersion = al.get(position);

        String starsString ="";

        for(int i = 0; i < currentVersion.getStars(); i++){
            starsString += "*";
        }

        tvpurple.setText(currentVersion.getTitle());
        tvplain.setText(String.valueOf(currentVersion.getYearReleased()));
        tvred.setText(starsString);
        tvblue.setText(currentVersion.getSingers());


        return rowView;


    }
}
