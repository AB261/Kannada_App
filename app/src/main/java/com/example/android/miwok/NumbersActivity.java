package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteController;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

   private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.words_list);setContentView(R.layout.words_list);
        mAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Words> words =
                 new ArrayList<Words>(Arrays.asList(new Words("One","Ondu",R.drawable.number_one,R.raw.number_one),new Words("Two","Yeredu",R.drawable.number_two,R.raw.number_two),new Words("Three","Muru",R.drawable.number_three,R.raw.number_three),new Words("Four","Nalku",R.drawable.number_four,R.raw.number_four),new Words("Five","Eidu",R.drawable.number_five,R.raw.number_five),new Words("Six","Aru",R.drawable.number_six,R.raw.number_six),new Words("Seven","Yelu",R.drawable.number_seven,R.raw.number_seven),new Words("Eight","Yentu",R.drawable.number_eight,R.raw.number_eight),new Words("Nine","Ombatu",R.drawable.number_nine,R.raw.number_nine),new Words("Ten","Hathu",R.drawable.number_ten,R.raw.number_ten)));

        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(pos).getAudio_res_id());
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                mMediaPlayer.start();
               mMediaPlayer.setOnCompletionListener(mCompletionListener);


            }}
        });



        listView.setAdapter(wordAdapter);


    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null)
            mMediaPlayer.release();
        mMediaPlayer=null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        mAudioManager.abandonAudioFocus(afChangeListener);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

