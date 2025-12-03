/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.entidades;

/**
 *
 * @author RIPCONCIV
 */
public class VueloListado {
    private int idvuelo;
    private String origen;
    private String destino;
    private int capacidad;
    private int ocupados = 0;
    private String puerta;  // NUEVO

    public VueloListado() {
    }

    public VueloListado(int idvuelo, String origen, String destino, int capacidad,int ocupados, String puerta) {
        this.idvuelo = idvuelo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
        this.ocupados=ocupados;
        this.puerta = puerta;
    }

    public int getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(int idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Override
    public String toString() {
        return "VueloListado{" + "idvuelo=" + idvuelo + ", origen=" + origen + ", destino=" + destino + ", capacidad=" + capacidad + ", ocupados=" + ocupados + ", puerta=" + puerta + '}';
    }
}
