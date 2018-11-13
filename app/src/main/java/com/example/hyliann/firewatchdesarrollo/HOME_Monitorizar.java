package com.example.hyliann.firewatchdesarrollo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.hyliann.firewatchdesarrollo.adapters.HumedadAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.HumoAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.TemperaturaAdapter;

public class HOME_Monitorizar extends AppCompatActivity {

    ArrayList<String> sectores;
    RecyclerView rv_humo;
    RecyclerView rv_humedad;
    RecyclerView rv_temperatura;
    Toolbar toolbar;
    Toolbar toolbar_buscar;
    HumoAdapter humoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorizar);
        SetListHumo();
        SetListHumedad();
        SetListTemperatura();
        //toolbar= (Toolbar) findViewById(R.id.toolbar);//BUG CRASH APP!!!!!!!!!!!!!!
        //setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //toolbar_buscar= (Toolbar) findViewById(R.id.toolbar_buscar);
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.buscar_item,menu);//set_xml
        //toolbar_buscar.inflateMenu(R.menu.buscar_item);
        MenuItem menuItem=menu.findItem(R.id.item_buscar);//get desde xml
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {//agregar get busqeda al aceptar
                Toast.makeText(getApplicationContext(), "Buscando...",Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//Agregar logica de busqeda al escribir
                Toast.makeText(getApplicationContext(), newText,Toast.LENGTH_SHORT).show();
                return true;
            }
        });

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
        humoAdapter=new HumoAdapter(sectores);
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
