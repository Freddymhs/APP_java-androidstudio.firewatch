package com.example.hyliann.firewatchdesarrollo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
    private final int DURACION_SPLASH = 1100;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);//generico
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//oritentacion
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscren

        setContentView(R.layout.activity_splash);//generico

        new Handler().postDelayed(new Runnable() {//metodo PostDelayed , efecto splash
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }


        }, DURACION_SPLASH);
    }
}