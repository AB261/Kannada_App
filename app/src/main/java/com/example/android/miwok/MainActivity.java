/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView num = (TextView) findViewById(R.id.numbers);
        TextView phs = (TextView) findViewById(R.id.phrases);
        TextView clr = (TextView) findViewById(R.id.colors);
        TextView fml = (TextView) findViewById(R.id.family);


        num.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent num = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(num);
            }
        });
        phs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(n);
            }
        });
        clr.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(s);
            }
        });
        fml.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(l);
            }
        });




    }


}