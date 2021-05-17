package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Tanishq is a bitch");
        list.add("Priyanka loves bitch");
        Button button = (Button) findViewById(R.id.button);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.progress);
        TextView cancel = (TextView) findViewById(R.id.cancel) ;
        TextView add = (TextView) findViewById(R.id.add);
        EditText editText = (EditText) findViewById(R.id.editText);

        //class ka name aata hai
        //this hi likhna hai, jahan list items hai(individual) , name of array list
        adapter ad = new adapter(this, R.layout.list_items,list);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(ad);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.VISIBLE);
                editText.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(String.valueOf(editText.getText()));
                relativeLayout.setVisibility(View.GONE);
                ad.notifyDataSetChanged();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                ad.notifyDataSetChanged();
            }
        });




    }
}