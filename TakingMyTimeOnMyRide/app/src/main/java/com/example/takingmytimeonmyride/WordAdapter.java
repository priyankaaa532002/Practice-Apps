package com.example.takingmytimeonmyride;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> words = new ArrayList<>();

    public WordAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Word> objects) {
        super(context, resource, objects);
        words = objects;
    }

    @Nullable
    @Override
    public Word getItem(int position) {
        return words.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.text1);
        textView1.setText(getItem(position).getText1());
        TextView textView2 = (TextView) convertView.findViewById(R.id.text2);
        textView2.setText(getItem(position).getText2());
        TextView textView3 = (TextView) convertView.findViewById(R.id.text3);
        textView3.setText(getItem(position).getText3());
        return convertView;
    }
}
