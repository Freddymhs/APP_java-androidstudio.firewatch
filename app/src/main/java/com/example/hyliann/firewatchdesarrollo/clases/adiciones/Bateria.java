package com.example.hyliann.firewatchdesarrollo.clases.adiciones;

public class Bateria {

    private int nivelDeCarga; // el estado de la bateria actual deberia capturarse del arduino


    //constructor
    public Bateria(int nivelDeCarga) {
        this.nivelDeCarga = nivelDeCarga;
    }

    ///geters y setters
    public int getNivelDeCarga() {
        return nivelDeCarga;
    }

    public void setNivelDeCarga(int nivelDeCarga) {
        this.nivelDeCarga = nivelDeCarga;
    }
}
