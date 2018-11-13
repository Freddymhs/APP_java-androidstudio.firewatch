package com.example.hyliann.firewatchdesarrollo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;

import com.example.hyliann.firewatchdesarrollo.adapters.HumedadAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.HumoAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.TemperaturaAdapter;

public class HOME_Monitorizar extends AppCompatActivity {

    ArrayList<String> sectores;
    RecyclerView rv_humo;
    RecyclerView rv_humedad;
    RecyclerView rv_temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorizar);
        SetListHumo();
        SetListHumedad();
        SetListTemperatura();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private ArrayList<String> AgregarSectores(){//cambiar por sectores de cada tipo de lista para filtrar...
        ArrayList<String> sectoreslist=new ArrayList<>();
        for(int i=0;i<10;i++){
            sectoreslist.add(" Sector "+(i+1));
        }
        return sectoreslist;
    }

    private void SetListHumo(){
        rv_humo= (RecyclerView) findViewById(R.id.rv_humo);
        rv_humo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sectores=AgregarSectores();
        HumoAdapter humoAdapter=new HumoAdapter(sectores);
        rv_humo.setAdapter(humoAdapter);
    }

    private void SetListHumedad(){
        rv_humedad= (RecyclerView) findViewById(R.id.rv_humedad);
        rv_humedad.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sectores=AgregarSectores();
        HumedadAdapter humedadAdapter=new HumedadAdapter(sectores);
        rv_humedad.setAdapter(humedadAdapter);
    }

    private void SetListTemperatura(){
        rv_temperatura= (RecyclerView) findViewById(R.id.rv_temperatura);
        rv_temperatura.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<String> sectores_temperatura=AgregarSectores();
        TemperaturaAdapter temperaturaAdapter=new TemperaturaAdapter(sectores_temperatura);
        rv_temperatura.setAdapter(temperaturaAdapter);
    }
}
