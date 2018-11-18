package com.example.hyliann.firewatchdesarrollo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.hyliann.firewatchdesarrollo.fragments.HistorialFragment;
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
    //Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//1
        inflater.inflate(R.menu.barra_item, menu); // 2
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home:
                Intent intent=new Intent(this,Activity_Home_.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
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
