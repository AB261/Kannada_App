package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Words> {
    private int clr;

    public WordAdapter(Activity context, ArrayList<Words>wd,int color)
    {
        super(context,0,wd);
        clr=color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        View textcontainer=listItemView.findViewById(R.id.textcontain);
        int color= ContextCompat.getColor(getContext(),clr);
        textcontainer.setBackgroundColor(color);
        Words currentword=getItem(position);
        TextView miwoktr=(TextView)listItemView.findViewById(R.id.one);
        miwoktr.setText(currentword.getMiwoktr());
        TextView Defaultt=(TextView)listItemView.findViewById(R.id.two);
        Defaultt.setText(currentword.getDefaulttr());
        ImageView Image = (ImageView) listItemView.findViewById(R.id.img);
        if(currentword.hasImg_res_id()==true) {

            Image.setImageResource(currentword.getImg_res_id());
            Image.setVisibility(View.VISIBLE);
        }
        else {


            Image.setVisibility(View.GONE);
        }

        return listItemView;

    }
}
