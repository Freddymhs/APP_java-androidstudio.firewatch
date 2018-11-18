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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.hyliann.firewatchdesarrollo.clases.Arduino;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Arduino> dispositivos=new ArrayList<>();//asignarle a otra clase contenedora de dispositivos....
    ListView lv_dispositivos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); /// orientacion fija
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove App Title bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_dispositivos = (ListView) findViewById(R.id.lv_dispositivos);
        AgregarDispositivos();

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
    //fixear para mostrar solo el nombre de los dispositivos en la lista...
    void AgregarDispositivos(){
        dispositivos.add(new Arduino("Arduino1"));
        dispositivos.add(new Arduino("Arduino2"));
        dispositivos.add(new Arduino("Arduino3"));
        dispositivos.add(new Arduino("Arduino7"));
        dispositivos.add(new Arduino("Rasperri3.14"));
        dispositivos.add(new Arduino("Unknown"));
        dispositivos.add(new Arduino("Glados"));
        dispositivos.add(new Arduino("Talos"));

        ArrayAdapter<Arduino> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dispositivos);
        lv_dispositivos.setAdapter(adapter);
    }
}
