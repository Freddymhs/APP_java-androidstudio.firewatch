package com.example.hyliann.firewatchdesarrollo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import android.widget.Toolbar;

public class Activity_Home_ extends AppCompatActivity {
    //deslizar
    ///opciones d ebotones
    ///bateriaa
    //menu de home
    String mipantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);/// orientacion fija
        super.onCreate(savedInstanceState);
        mipantalla = this.getClass().getSimpleName().toString();
//        ActionBar bar = getActionBar();
//        Toast.makeText(this, "esta es : " +  mipantalla, Toast.LENGTH_SHORT).show();


        setContentView(R.layout.activity__home_);
        String nombreDispositivo = ""; //               name
        setTitle("Dispositivo #" + nombreDispositivo);// name
        setTitleColor(Color.BLACK);
    }


    @Override//Barra
    public boolean onCreateOptionsMenu(Menu menu) { //0
        MenuInflater inflater = getMenuInflater();//1
        inflater.inflate(R.menu.barra_item, menu); // 2

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mipantalla.equalsIgnoreCase("Activity_Home_")) {

//no hace nada  mismo metodo que en Framents
        } else {
            switch (item.getItemId()) {
                case R.id.item_home:
                    Intent intento = new Intent(this, Activity_Home_.class);//intento a home
                    startActivity(intento);//intento a home
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //fin Barra
    ///animacion y BOTONES

    public void LEFT(View view) {/// PANTALLA  CONTROLAR
        Intent intent = new Intent(this, HOME_Seguimiento.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);// mov  animacion
    }

    public void RIGHT(View view) {/// PANTALLA  SEGUIMIENTO
        Intent intent = new Intent(this, HOME_Controlar.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// mov  animacion
    }

    public void DOWN(View view) {/// PANTALLA  SEGUIMIENTO
        Intent intent = new Intent(this, HOME_Monitorizar.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);// mov  animacion
    }

}
