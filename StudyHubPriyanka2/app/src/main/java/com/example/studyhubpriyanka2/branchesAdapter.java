package com.example.studyhubpriyanka2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class branchesAdapter extends ArrayAdapter<branches>{
    ArrayList<branches> branches;
    public branchesAdapter(@NonNull Context context, int resource , @NonNull ArrayList<branches> objects){
        super(context,resource,objects);
        this.branches = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_it,parent,false);
        TextView subject = (TextView)convertView.findViewById(R.id.subject);
        subject.setText(getItem(position).getSubject());

        TextView code = (TextView)convertView.findViewById((R.id.code));
        code.setText(getItem(position).getCode());

        TextView credits = (TextView)convertView.findViewById(R.id.credits);
        credits.setText(getItem(position).getCredits());

        TextView modules = (TextView)convertView.findViewById(R.id.modules);
        modules.setText(getItem(position).getModules());

        return convertView;
    }
}