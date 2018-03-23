package com.example.aishwaryasathyadas.veyec;

/**
 * Created by aishwaryasathyadas on 11/03/2018.
 */
import java.net.*;
//import java.lang.String;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import static android.net.Uri.parse;

public class Video extends AppCompatActivity {

    VideoView tutorialVideoVideoView;
    Uri uri = null;
    URL url = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

//Bundle extras=getIntent().getExtras();

        String myUrlStr=getIntent().getStringExtra("Extras");

        tutorialVideoVideoView = (VideoView) findViewById(R.id.tutorial_video_video_view);

       // uri = Uri.parse(url);

        try {
            url = new URL(myUrlStr);
            uri = Uri.parse( url.toURI().toString() );
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();
        //tutorialVideoVideoView.setVideoURI(uri.toString());
        tutorialVideoVideoView.setVideoURI(uri);


       Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorialVideoVideoView.start();
            }
        });

    }

}
