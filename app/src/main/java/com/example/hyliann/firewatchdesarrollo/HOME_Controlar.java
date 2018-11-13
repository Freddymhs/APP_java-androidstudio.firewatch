package com.example.hyliann.firewatchdesarrollo;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

public class HOME_Controlar extends AppCompatActivity {
    private MapView mapView; /// var para MAPA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);/// orientacion fija
        setTitle("CONTROLAR");
        setTitleColor(Color.BLACK);
        super.onCreate(savedInstanceState);
        //MAPA
        Mapbox.getInstance(this, getString(R.string.access_token));//
        //MAPA
        setContentView(R.layout.activity_home__controlar);//

        //mapa aun....
        mapView = (MapView) findViewById(R.id.mapView);//
        mapView.onCreate(savedInstanceState);//
        //MAPA

    }

    //////metodos para el mapa
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {//
        super.onSaveInstanceState(outState);//
        mapView.onSaveInstanceState(outState);//
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    /////////////////metodos para el mapa


}
