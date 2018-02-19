package com.example.roberto.exm2android;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.roberto.exm2android.entity.Locations;
import com.example.roberto.exm2android.fragment.MapDetailFragment;
import com.example.roberto.exm2android.gpsAdmin.GpsTracker;
import com.google.android.gms.maps.SupportMapFragment;


public class SecondActivity extends AppCompatActivity {

    SupportMapFragment mapFragment;
    SecondActivityEvents events;
    MapDetailFragment mapDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mapDetailFragment = (MapDetailFragment) getSupportFragmentManager().findFragmentById(R.id.mapDetail);

        events = new SecondActivityEvents(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(events);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(mapDetailFragment);
        transaction.commit();

        GpsTracker gpsTracker = new GpsTracker(this);
        if (gpsTracker.canGetLocation()) {
           System.out.println("Latitud: "+gpsTracker.getLatitude());
           System.out.println("Longitud: "+gpsTracker.getLongitude());
//            double lat, double lon, String name, String country, String poblation
          Locations locations = new Locations(gpsTracker.getLatitude(),gpsTracker.getLongitude(),"My Location","España","-");
//            fireBaseAdmin.insertBranch("Locations/5",locations.toMap());

        }else{
            gpsTracker.showSettingsAlert();
        }


    }


}
