package com.app.swachhbharat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminPanel extends AppCompatActivity {

    private ListView listView;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private LocationSwach locationSwach;
    private ArrayList<String> Lattitude;
    private ArrayList<String> Longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        locationSwach = new LocationSwach();
        listView = findViewById(R.id.listView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Locations");
        list = new ArrayList<>();
        Lattitude = new ArrayList<>();
        Longitude = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.location_layout,R.id.LocationInfo,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    locationSwach = ds.getValue(LocationSwach.class);
                    list.add("Lattitude : "+locationSwach.getLattitude()+ "     Longitude : "+locationSwach.getLongitude());
                    Lattitude.add(String.valueOf(locationSwach.getLattitude()));
                    Longitude.add(String.valueOf(locationSwach.getLongitude()));
                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+Lattitude.get(position)+","+Longitude.get(position)+"(Clean)"));
                startActivity(intent);
            }
        });


    }
}
