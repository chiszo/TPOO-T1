
package com.airpot.airport.t1poo;


public class Vuelo {
    
    private int idvuelo;
    private String origen;
    private String destino;
    private int capacidad;
    private int ocupados = 0;
    private int idpuerta;  // NUEVO

    public Vuelo() {}

    public Vuelo(int idvuelo, String origen, String destino, int capacidad, int idpuerta) {
        this.idvuelo = idvuelo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
        this.idpuerta = idpuerta;
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

    public int getIdpuerta() {
        return idpuerta;
    }

    public void setIdpuerta(int idpuerta) {
        this.idpuerta = idpuerta;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idvuelo=" + idvuelo + ", origen=" + origen + ", destino=" + destino + ", capacidad=" + capacidad + ", ocupados=" + ocupados + ", idpuerta=" + idpuerta + '}';
    }


}
