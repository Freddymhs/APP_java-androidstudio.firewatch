package com.example.hyliann.firewatchdesarrollo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// orientacion fija


//        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove App Title bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void irHOME(View view) {
        Intent Intnt = new Intent(this, Activity_Home_.class);
        startActivity(Intnt);
    }
}
