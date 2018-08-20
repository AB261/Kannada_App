package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        ArrayList<Words> words =
                new ArrayList<Words>(Arrays.asList(new Words("Food","Utta"),new Words("Hospital","Aspathre"),new Words("House","Mane"),new Words("Water","Neru"),new Words("Toilet","Toilet"),new Words("Village","Halli"),new Words("Playground","Kredagona"),new Words("How to go to ...","Hege hoga beku"),new Words("How much will it take?","Yeshtu aguthe"),new Words("Go to this address...","Ee addresige hoge")));

        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);


    }
}
