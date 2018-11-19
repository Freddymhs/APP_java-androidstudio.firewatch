package com.example.hyliann.firewatchdesarrollo.clases;

import com.example.hyliann.firewatchdesarrollo.clases.adiciones.Bateria;
import com.example.hyliann.firewatchdesarrollo.clases.adiciones.Sensor;

import java.util.ArrayList;

public class Arduino {
//una clase que se podria llamar en otras activitys


    private String nombreDelDispositivoDESIGNADO;  //se genera automaticamente
    private String codigoBlueDESIGNADO;  //se captura con un metodo y se guarda
    private int velocidadDESIGNADO; // inician en 0 todos
    private String numeroAlertaDESIGNADO;  //se rellena por el usuario
    private Bateria bateriaDaparato;   // un objeto BATERIA que es parte de clase "arduino"                -CLASE objeto
    private ArrayList<Sensor> SensoresDaparato; //un arraylist SENSORES que es parte de clase"arduino"     -CLASE objeto array

///pantalla de setter usuario
    //nombre asignado al arduino
    //codigo bluethot asignado pero no se ense;a ssolo se avisa
    //numero de alerta para llamar al celular
    //los sensores detectados y setear sus rangos de deteccion

    //constructores


    public Arduino() {

    }

    public Arduino(String nombreDelDispositivoDESIGNADO) {
        this.nombreDelDispositivoDESIGNADO = nombreDelDispositivoDESIGNADO;
        this.codigoBlueDESIGNADO = "888888888";
        this.velocidadDESIGNADO = 0; // detenidos todos los dispositivos por default
        this.numeroAlertaDESIGNADO = "+958020188";
        this.bateriaDaparato = new Bateria(100);
    }

    public Arduino(Bateria bateriaDaparato, ArrayList<Sensor> sensoresDaparato) {
        this.nombreDelDispositivoDESIGNADO = "DISPOSITIVO #1";
        this.codigoBlueDESIGNADO = "888888888";
        this.velocidadDESIGNADO = 0; // detenidos todos los dispositivos por default
        this.numeroAlertaDESIGNADO = "+958020188";  //
        this.bateriaDaparato = bateriaDaparato;
        SensoresDaparato = sensoresDaparato;
    }

    public Arduino(String nombreDelDispositivoDESIGNADO, String codigoBlueDESIGNADO, int velocidadDESIGNADO, String numeroAlertaDESIGNADO, Bateria bateriaDaparato, ArrayList<Sensor> sensoresDaparato) {
        this.nombreDelDispositivoDESIGNADO = "DISPOSITIVO #1";
        this.codigoBlueDESIGNADO = "888888888";
        this.velocidadDESIGNADO = 0; // detenidos todos los dispositivos por default
        this.numeroAlertaDESIGNADO = "+958020188";  //
        this.bateriaDaparato = bateriaDaparato; //
        SensoresDaparato = sensoresDaparato; //

    }

//-
    ///

    //getters setters
    public String getNombreDelDispositivoDESIGNADO() {
        return nombreDelDispositivoDESIGNADO;
    }

    public void setNombreDelDispositivoDESIGNADO(String nombreDelDispositivoDESIGNADO) {
        this.nombreDelDispositivoDESIGNADO = nombreDelDispositivoDESIGNADO;
    }

    public String getCodigoBlueDESIGNADO() {
        return codigoBlueDESIGNADO;
    }

    public void setCodigoBlueDESIGNADO(String codigoBlueDESIGNADO) {
        this.codigoBlueDESIGNADO = codigoBlueDESIGNADO;
    }

    public int getVelocidadDESIGNADO() {
        return velocidadDESIGNADO;
    }

    public void setVelocidadDESIGNADO(int velocidadDESIGNADO) {
        this.velocidadDESIGNADO = velocidadDESIGNADO;
    }

    public String getNumeroAlertaDESIGNADO() {
        return numeroAlertaDESIGNADO;
    }

    public void setNumeroAlertaDESIGNADO(String numeroAlertaDESIGNADO) {
        this.numeroAlertaDESIGNADO = numeroAlertaDESIGNADO;
    }

    public Bateria getBateriaDaparato() {
        return bateriaDaparato;
    }

    public void setBateriaDaparato(Bateria bateriaDaparato) {
        this.bateriaDaparato = bateriaDaparato;
    }

    public ArrayList<Sensor> getSensoresDaparato() {
        return SensoresDaparato;
    }

    public void setSensoresDaparato(ArrayList<Sensor> sensoresDaparato) {
        SensoresDaparato = sensoresDaparato;
    }

    @Override
    public String toString() {
        return this.nombreDelDispositivoDESIGNADO;
    }
}
