package com.example.contactrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Contact o1 = new Contact(1,"9292929292","Harry");
    Contact o2 = new Contact(2,"9292929292","Harry");
    Contact o3 = new Contact(3,"9292929292","Harry");
    Contact o4 = new Contact(4,"9292929292","Harry");
    Contact o5 = new Contact(5,"9292929292","Harry");
    Contact o6 = new Contact(6,"9292929292","Harry");
    Contact o7 = new Contact(7,"9292929292","Harry");
    Contact o8 = new Contact(8,"9292929292","Harry");
    Contact o9 = new Contact(9,"9292929292","Harry");


    Contact [] contacts = {o1,o2,o3,o4,o5,o6,o7,o8,o9};

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter ad = new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}