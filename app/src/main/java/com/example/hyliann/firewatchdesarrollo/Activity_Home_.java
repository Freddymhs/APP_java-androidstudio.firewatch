package com.example.hyliann.firewatchdesarrollo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Activity_Home_ extends AppCompatActivity {
    //deslizar
    ///opciones d ebotones
    ///bateria
    //menu de home
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__home_);

        String nombreDispositivo = ""; //               name
        setTitle("Dispositivo #" + nombreDispositivo);// name
    }


    @Override//Barra
    public boolean onCreateOptionsMenu(Menu menu) { //0
        MenuInflater inflater = getMenuInflater();//1
        inflater.inflate(R.menu.barra_item, menu); // 2

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_home:
                Intent intento = new Intent(this, Activity_Home_.class);//intento a home
                startActivity(intento);//intento a home

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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);// mov  animacion
    }

}
