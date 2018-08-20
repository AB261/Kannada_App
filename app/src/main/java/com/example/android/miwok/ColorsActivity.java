package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        ArrayList<Words> words =
                new ArrayList<Words>(Arrays.asList(new Words("Black","Kapu",R.drawable.color_black),new Words("Yellow","Arishna",R.drawable.color_dusty_yellow),new Words("Green","Haladi",R.drawable.color_green),new Words("White","Boldu",R.drawable.color_white),new Words("Red","Kempu",R.drawable.color_red),new Words("Brown","Brownu",R.drawable.color_brown)));

        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);


    }
}
