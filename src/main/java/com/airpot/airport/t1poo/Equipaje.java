
package com.airpot.airport.t1poo;


public class Equipaje {
     private String idPasajero;
    private double pesoKg;

    public Equipaje() {}

    public Equipaje(String idPasajero, double pesoKg) {
        this.idPasajero = idPasajero;
        this.pesoKg = pesoKg;
    }

    public String getIdPasajero() { return idPasajero; }
    public void setIdPasajero(String idPasajero) { this.idPasajero = idPasajero; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    @Override
    public String toString() {
        return "Equipaje de " + idPasajero + " | " + pesoKg + " kg";
    }
}
