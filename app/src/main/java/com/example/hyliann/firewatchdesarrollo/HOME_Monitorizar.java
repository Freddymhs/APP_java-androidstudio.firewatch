package com.example.hyliann.firewatchdesarrollo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import com.example.hyliann.firewatchdesarrollo.adapters.HumedadAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.HumoAdapter;
import com.example.hyliann.firewatchdesarrollo.adapters.TemperaturaAdapter;
import com.example.hyliann.firewatchdesarrollo.fragments.HistorialFragment;

public class HOME_Monitorizar extends AppCompatActivity {

    ArrayList<String> sectores;
    RecyclerView rv_humo;
    RecyclerView rv_humedad;
    RecyclerView rv_temperatura;
    HumoAdapter humoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorizar);
        rv_humo= (RecyclerView) findViewById(R.id.rv_humo);
        rv_humedad= (RecyclerView) findViewById(R.id.rv_humedad);
        rv_temperatura= (RecyclerView) findViewById(R.id.rv_temperatura);
        SetListHumo(false);
        SetListHumedad();
        SetListTemperatura();
        getSupportActionBar().setTitle("Monitorizar");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.buscar_item,menu);//set_xml
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

    private void SetListHumo(boolean modegrid){
        //rv_humo= (RecyclerView) findViewById(R.id.rv_humo);
        if(modegrid){
            rv_humo.setLayoutManager(new GridLayoutManager(this, 2));
        }else {
            rv_humo.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        }
        sectores=AgregarSectores();
        humoAdapter=new HumoAdapter(sectores);
        rv_humo.setAdapter(humoAdapter);
    }

    private void SetListHumedad(){
        //rv_humedad= (RecyclerView) findViewById(R.id.rv_humedad);
        rv_humedad.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sectores=AgregarSectores();
        HumedadAdapter humedadAdapter=new HumedadAdapter(sectores);
        rv_humedad.setAdapter(humedadAdapter);
    }

    private void SetListTemperatura(){
        //rv_temperatura= (RecyclerView) findViewById(R.id.rv_temperatura);
        rv_temperatura.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<String> sectores_temperatura=AgregarSectores();
        TemperaturaAdapter temperaturaAdapter=new TemperaturaAdapter(sectores_temperatura);
        rv_temperatura.setAdapter(temperaturaAdapter);
    }

    private void SetVista(RecyclerView lista){
        if(lista.getLayoutManager() instanceof GridLayoutManager){
            lista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        }else {
            lista.setLayoutManager(new GridLayoutManager(this, 2));
        }
        RefreshSectores(lista);

    }

    private void RefreshSectores(RecyclerView lista){
        RecyclerView.Adapter adapter=null;
        switch (lista.getId()){
            case R.id.rv_humo:
                sectores=AgregarSectores();
                adapter=new HumoAdapter(sectores);//Customizar para cada adaptador de cada sensor
                break;
            case R.id.rv_humedad:
                sectores=AgregarSectores();
                adapter=new HumoAdapter(sectores);//Customizar para cada adaptador de cada sensor
                break;
            case R.id.rv_temperatura:
                sectores=AgregarSectores();
                adapter=new HumoAdapter(sectores);//Customizar para cada adaptador de cada sensor
                break;
        }
        lista.setAdapter(adapter);
    }

    public void ChangeView(View view) {
        switch (view.getId()){
            case R.id.tv_humo:
                SetVista(rv_humo);
                break;
            case R.id.tv_humedad:
                SetVista(rv_humedad);
                break;
            case R.id.tv_temperatura:
                SetVista(rv_temperatura);
                break;
        }
    }
}
