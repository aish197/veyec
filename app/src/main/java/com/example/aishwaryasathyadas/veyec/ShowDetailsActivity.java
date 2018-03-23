package com.example.aishwaryasathyadas.veyec;

/**
 * Created by aishwaryasathyadas on 11/03/2018.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDetailsActivity extends AppCompatActivity {



    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<Details> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        final EditText loc = findViewById(R.id.loc_search);
        final Button searchbutton = findViewById(R.id.searchbutton);
        findViewById(R.id.searchbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loc.setVisibility(View.INVISIBLE);
                searchbutton.setVisibility(View.INVISIBLE);

                location = loc.getText().toString();

                Log.w("locationview",location);
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

                recyclerView.setHasFixedSize(true);

                recyclerView.setLayoutManager(new LinearLayoutManager(ShowDetailsActivity.this));

                progressDialog = new ProgressDialog(ShowDetailsActivity.this);

                progressDialog.setMessage("Loading Data");

                progressDialog.show();

                databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity.Database_Path);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                            Details studentDetails = dataSnapshot.getValue(Details.class);
                            Log.w("locationview","location is "+studentDetails.getLocation());
                            String loc = studentDetails.getLocation();
                            if(loc.equals(location)) {
                                list.add(studentDetails);
                            }

                        }

                        adapter = new RecyclerViewAdapter(ShowDetailsActivity.this, list);

                        recyclerView.setAdapter(adapter);

                        progressDialog.dismiss();


                        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                Details studentdetails = list.get(position);
                                Intent intent = new Intent(ShowDetailsActivity.this, Video.class);
                                intent.putExtra("Extras", studentdetails.getVideourl());
                                startActivity(intent);
                            }

                            @Override
                            public void onLongClick(View view, int position) {

                            }
                        }));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        progressDialog.dismiss();

                    }
                });
            }

        });
    }
}