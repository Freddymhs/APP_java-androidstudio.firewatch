package com.example.hyliann.firewatchdesarrollo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// orientacion fija


//        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove App Title bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void irHOME(View view) {//llama al cuadro de alerta
        //Intent Intnt = new Intent(this, Activity_Home_.class);
        //startActivity(Intnt);
        AlertSincronizar().show();
    }

    public AlertDialog AlertSincronizar() {//...agregar style en dialog_sicronizar.xml
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_sincronizar, null);

        builder.setView(v);
        Button aceptar = (Button) v.findViewById(R.id.bt_aceptar);
        Button cancelar = (Button) v.findViewById(R.id.bt_cancelar);
        AlertDialog alertDialog=builder.create();

        aceptar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//Llama al registro en formato alert
                        Intent Intnt = new Intent(MainActivity.this, RegistroActivity.class);
                        startActivity(Intnt);
                        alertDialog.dismiss();
                    }
                }
        );
        cancelar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//Cancelar
                        alertDialog.dismiss();
                    }
                }

        );

        return alertDialog;
    }
}
