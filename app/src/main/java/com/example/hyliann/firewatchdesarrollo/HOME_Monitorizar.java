package com.example.hyliann.firewatchdesarrollo;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HOME_Monitorizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);/// orientacion fija
        setTitle("MONITORIZAR");
        setTitleColor(Color.BLACK);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__monitorizar);


    }
}
