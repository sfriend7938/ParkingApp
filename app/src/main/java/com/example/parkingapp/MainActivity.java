package com.example.parkingapp;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //initialize background video variables
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;

    //initialize variable for the button that user pushes to login
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the video view to be the video view in our video_sign_in xml layout
        videoBG = (VideoView)findViewById(R.id.videoView);

        //set the video uri equal to the video file
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.parkinglot);

        //set the video view to the video uri
        videoBG.setVideoURI(uri);
        //start the video view
        videoBG.start();

        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer = mp;
                //allows the video to loop over and over again
                mMediaPlayer.setLooping(true);
                //go to current position if it has been set and play the video
                if(mCurrentVideoPosition != 0){
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });

        Spinner spinner = findViewById(R.id.destinationSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.destinationAddresses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        loginButton = (Button)findViewById(R.id.btLogInButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(v);
            }
        });

    }

    public void onLogin(View view){
        Intent intent = new Intent(this, TransitionActivity.class);
        startActivity(intent);
    }

    /*Must override the onPause, onResume, and onDestroy methods to properly handle the video view such that it reloads*/

    //make note of the current video position, and pause the video
    @Override
    protected void onPause() {
        super.onPause();
        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    //restart the video when resuming the activity
    @Override
    protected void onResume() {
        super.onResume();
        videoBG.start();
    }

    //when the activity is destroyed, release the media player and set it to null
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

    public boolean isEnabled(int position){
        if(position == 0){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
