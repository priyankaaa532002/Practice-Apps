package com.example.studyhubpriyanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class IT extends AppCompatActivity {
    public static final String LOG_TAG = IT.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_t);


        ArrayList<branches> branch = new ArrayList<branches>();
        branch.add(new branches("Data Structures","Code - ITE1004", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Web Technologies","Code - ITE1002", "Credits - 3", "Modules - 8"));
        branch.add(new branches("Network And IS","Code - ITE4001", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Linear Algebra","Code - MAT3004", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Java Programming","Code - CSE1007", "Credits - 4", "Modules - 8"));
        branch.add(new branches("DLM","Code - ITE1006", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Operating Systems","Code - ITE1004", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Data Structures","Code - ITE2002", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Discrete Mathematics","Code - MAT1014", "Credits - 4", "Modules - 8"));
        branch.add(new branches("Software Engine","Code - ITE1005", "Credits - 4", "Modules - 8"));

        branchesAdapter adapter = new branchesAdapter(this,R.layout.items_it,branch);
        ListView branchesListView = (ListView) findViewById(R.id.list_it);
        branchesListView.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(),"data" + bundle.getString("some"),Toast.LENGTH_SHORT).show();
            }
        }
    }
}