package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String arr[]={"This is", "Item" , "Item2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
//        listView.setAdapter(ad);

        //Custom adapter
        PriyankaAdapter ad = new PriyankaAdapter(this,  R.layout.my_priyanka_layout , arr);
        listView.setAdapter(ad);
    }
}