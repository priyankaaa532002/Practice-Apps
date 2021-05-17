package com.example.takingmytimeonmyride;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","bla","blah"));
        words.add(new Word("hello","hi","helyoo"));
        words.add(new Word("meow","mew","meeeoooww"));
        words.add(new Word("huihui","huhu","hululu"));
        words.add(new Word("google","cousre","bad"));
        words.add(new Word("baby","good","teacher"));
        words.add(new Word("i","love","baby"));


        WordAdapter ad = new WordAdapter(this,R.layout.list_items,words);
        ListView rootView = (ListView)findViewById(R.id.rootView);
        rootView.setAdapter(ad);

    }


}