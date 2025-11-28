
package com.airpot.airport.t1poo.entidades;


public class Equipaje {
    private int idequipaje;
    private int idpasajero;
    private double peso;

    public Equipaje() {}

    public Equipaje(int idequipaje, int idpasajero, double peso) {
        this.idequipaje = idequipaje;
        this.idpasajero = idpasajero;
        this.peso = peso;
    }

    public int getIdequipaje() {
        return idequipaje;
    }

    public void setIdequipaje(int idequipaje) {
        this.idequipaje = idequipaje;
    }

    public int getIdpasajero() {
        return idpasajero;
    }

    public void setIdpasajero(int idpasajero) {
        this.idpasajero = idpasajero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Equipaje{" + "idequipaje=" + idequipaje + ", idpasajero=" + idpasajero + ", peso=" + peso + '}';
    }
}
