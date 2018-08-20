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

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        ArrayList<Words> words =
                new ArrayList<Words>(Arrays.asList(new Words("Dad","Appa",R.drawable.family_father),new Words("Mom","Amma",R.drawable.family_mother),new Words("Little Sister","Thangi",R.drawable.family_younger_sister),new Words("Little Brother","Thamma",R.drawable.family_younger_brother),new Words("Big sister","Akka",R.drawable.family_older_sister),new Words("Big Brother","Anna",R.drawable.family_older_brother),new Words("Grandmother","Aggi",R.drawable.family_grandmother),new Words("Grandfather","Agga",R.drawable.family_grandfather)));

        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);


    }
}