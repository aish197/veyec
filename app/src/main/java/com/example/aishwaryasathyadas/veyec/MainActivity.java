package com.example.aishwaryasathyadas.veyec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    
    Button DisplayButton;

    EditText date, phone, videourl,latitude,longitude,location;

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://phoneauth-ce710.firebaseio.com/";

    // Declaring String variables to store variable values get from EditText.
    String DateHolder, PhoneHolder, VideoHolder,LongitudeHolder,LatitudeHolder,LocationHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(MainActivity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        DisplayButton = (Button) findViewById(R.id.DisplayButton);


        Details studentDetails = new Details();

        studentDetails.setDate(DateHolder);
        studentDetails.setPhone(PhoneHolder);
        studentDetails.setVideourl(VideoHolder);
        studentDetails.setVideourl(LongitudeHolder);
        studentDetails.setVideourl(LatitudeHolder);
        studentDetails.setLocation(LocationHolder);


        // Showing Toast message after successfully data submit.
        Toast.makeText(MainActivity.this, " Loading Please wait", Toast.LENGTH_LONG).show();


        DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ShowDetailsActivity.class);
                startActivity(intent);

            }
        });

    }
}
