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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.hyliann.firewatchdesarrollo.clases.Arduino;
import com.example.hyliann.firewatchdesarrollo.clases.adiciones.Bateria;
import com.example.hyliann.firewatchdesarrollo.clases.adiciones.Sensor;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity_Home_ extends AppCompatActivity {
    //deslizar
    ///opciones d ebotones
    ///bateriaa
    //menu de home
    String mipantalla;
    String BARRAnombre;
    TextView tv_nombre;
    TextView tv_cantidadsens;
    TextView tv_tiposens;
    TextView tv_sensoresconproblemas;
    TextView tv_sensoressinproblemas;
    TextView tv_energiabateria;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);/// orientacion fija
        super.onCreate(savedInstanceState);
        mipantalla = this.getClass().getSimpleName().toString();
        //
        setContentView(R.layout.activity__home_);
        String nombreDispositivo = ""; //               name
        setTitle("Dispositivo #" + nombreDispositivo);// name
        setTitleColor(Color.BLACK);
    }
    // llenado de HOME

    @Override
    protected void onStart() {
        super.onStart();
        //
        Sensor S1 = new Sensor("humedad", "30", true);
        Sensor S2 = new Sensor("calor", "10", true);
        Sensor S3 = new Sensor("distancia", "10", true);
        Bateria bateriaArduino = new Bateria(77);


        ArrayList<Sensor> sensorArduino = new ArrayList<>();
        sensorArduino.add(S1);
        sensorArduino.add(S3);
        sensorArduino.add(S2);
        ArrayList<Arduino> mylista = new ArrayList<>(); // se crea los objetos
        mylista.add(0, new Arduino("aparato1", "1111", 0, "8321938", bateriaArduino, sensorArduino));
        tv_nombre = (TextView) findViewById(R.id.tv_NombredeDdispositivo);

        tv_cantidadsens = (TextView) findViewById(R.id.tv_cantidadSensores);
        tv_tiposens = (TextView) findViewById(R.id.tv_tiposensores);
        tv_sensoresconproblemas = (TextView) findViewById(R.id.tv_sensoresconproblemas);
        tv_sensoressinproblemas = (TextView) findViewById(R.id.tv_sensoressinproblemas);
        tv_energiabateria = (TextView) findViewById(R.id.tv_bateria);

        ///nombre del dispositivo
        //id de blueth para revisar en que indice fue asignado

        ////nombre dispositivo
        tv_nombre.setText(mylista.get(0).getNombreDelDispositivoDESIGNADO());
        //
        String estadoBateria;
        mylista.get(0).getBateriaDaparato().setNivelDeCarga(77);
        /////bateria
        if (mylista.get(0).getBateriaDaparato().getNivelDeCarga() > 20) {
            estadoBateria = "bajo";
            tv_energiabateria.setText("" + estadoBateria);
        }
        if (mylista.get(0).getBateriaDaparato().getNivelDeCarga() > 70) {
            estadoBateria = "medio";
            tv_energiabateria.setText("" + estadoBateria);
        }
        if (mylista.get(0).getBateriaDaparato().getNivelDeCarga() > 80) {
            estadoBateria = "casi llena";
            tv_energiabateria.setText("" + estadoBateria);
        }
        if (mylista.get(0).getBateriaDaparato().getNivelDeCarga() == 100) {
            estadoBateria = "completa";
            tv_energiabateria.setText("" + estadoBateria);
        }


        //////////
        //
        ///cantidad de sensores
        int totalSensores = 0; // comeinza en 0
        for (int i = 0; i < mylista.get(0).getSensoresDaparato().size(); i++) { // se necesita numero........
            totalSensores++;
        }
        tv_cantidadsens.setText("" + totalSensores);
        ///cantidad de sensores
        //
        //tipos de sensores
        mylista.get(0).getSensoresDaparato().get(0).getNombreSensor(); //dispositivo actual
        tv_tiposens.setText("" + "----");//no asignado aun
        // realizar contador de Nombre de sensores dentro del objeto sensor del array0
        boolean revisaBool;
        Integer matcherNoFuncionales = 0;
        Integer matcherSiFuncionales = 0;
        //tipos de sensores
        //
        //sensores funcionales y no funcionales   o con problemas
        if (true) {


            ///////////
            for (int i = 0; i < mylista.get(0).getSensoresDaparato().size(); i++) {

                revisaBool = mylista.get(0).getSensoresDaparato().get(i).getEstadoFuncional();

                if (revisaBool) {
                    matcherSiFuncionales++;
                } else {
                    matcherNoFuncionales++;
                }
            }

        }

        tv_sensoresconproblemas.setText("" + matcherNoFuncionales);
        tv_sensoressinproblemas.setText("" + matcherSiFuncionales);


    }//fin on create


    //


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
//        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_right);// mov  animacion
    }

}
