package com.example.android.miwok;

import android.widget.ImageView;
import android.widget.TextView;


public class Words{

    private String defaulttr;
    private String miwoktr;
    private static final int NOIMG=-1;
    private int img_res_id=NOIMG;
    private int audio_res_id;

    public Words(String t1,String t2,int image,int audio)
    {
        defaulttr=t1;
        miwoktr=t2;
        img_res_id=image;
        audio_res_id=audio;
    }
    public Words(String t1,String t2,int image)
    {
        defaulttr=t1;
        miwoktr=t2;
        img_res_id=image;

    }
    public Words(String t1,String t2)
    {
        defaulttr=t1;
        miwoktr=t2;

    }

    public String getDefaulttr()
    {
        return defaulttr;
    }

    public String getMiwoktr() {
        return miwoktr;
    }

    public int getImg_res_id() {
        return img_res_id;
    }
    public boolean hasImg_res_id(){
        if(img_res_id==NOIMG)
            return false;
        else return true;
    }

    public int getAudio_res_id() {
        return audio_res_id;
    }
}
