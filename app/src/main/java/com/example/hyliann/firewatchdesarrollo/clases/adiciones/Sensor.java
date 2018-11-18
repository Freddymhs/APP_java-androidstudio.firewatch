package com.example.hyliann.firewatchdesarrollo.clases.adiciones;

public class Sensor {

    //1 arduino - N sensores
    //sensores dentro del aparato arduino
    String NombreSensor;  //calor , humedad,distancia
    String valorDato; // grados u otro
    Boolean estadoFuncional;// 1  ,0  si esta activo o no el sensor


    //constructor  usados para tipos de sensores
    public Sensor() {
    }

    public Sensor(String nombreSensor, String valorDato, Boolean estadoFuncional) {
        NombreSensor = nombreSensor;
        this.valorDato = valorDato;
        this.estadoFuncional = estadoFuncional;
    }

    //get sett
    public String getNombreSensor() {
        return NombreSensor;
    }

    public void setNombreSensor(String nombreSensor) {
        NombreSensor = nombreSensor;
    }

    public String getValorDato() {
        return valorDato;
    }

    public void setValorDato(String valorDato) {
        this.valorDato = valorDato;
    }

    public Boolean getEstadoFuncional() {
        return estadoFuncional;
    }

    public void setEstadoFuncional(Boolean estadoFuncional) {
        this.estadoFuncional = estadoFuncional;
    }
    //

    //    public void metodoCantidadSensores(){
//    }


    ///getters y setters

}

