
package com.airpot.airport.t1poo;


public class TarjetaEmbarque {
    private int idtarjetaEmbarque;
    private int idpasajero;
    private int idpuerta;
    private String asiento;

    public TarjetaEmbarque() {}

    public TarjetaEmbarque(int idtarjetaEmbarque, int idpasajero, int idpuerta, String asiento) {
        this.idtarjetaEmbarque = idtarjetaEmbarque;
        this.idpasajero = idpasajero;
        this.idpuerta = idpuerta;
        this.asiento = asiento;
    }

    public int getIdtarjetaEmbarque() {
        return idtarjetaEmbarque;
    }

    public void setIdtarjetaEmbarque(int idtarjetaEmbarque) {
        this.idtarjetaEmbarque = idtarjetaEmbarque;
    }

    public int getIdpasajero() {
        return idpasajero;
    }

    public void setIdpasajero(int idpasajero) {
        this.idpasajero = idpasajero;
    }

    public int getIdpuerta() {
        return idpuerta;
    }

    public void setIdpuerta(int idpuerta) {
        this.idpuerta = idpuerta;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "TarjetaEmbarque{" + "idtarjetaEmbarque=" + idtarjetaEmbarque + ", idpasajero=" + idpasajero + ", idpuerta=" + idpuerta + ", asiento=" + asiento + '}';
    }
}
