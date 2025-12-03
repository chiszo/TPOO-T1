
package com.airpot.airport.t1poo.entidades;


public class Puerta {
    private int idpuerta;
    private String estado;

    public Puerta() {}

    public Puerta(int idpuerta, String estado) {
        this.idpuerta = idpuerta;
        this.estado = estado;
    }    
    

    public int getIdpuerta() {
        return idpuerta;
    }

    public void setIdpuerta(int idpuerta) {
        this.idpuerta = idpuerta;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado;
    }
}
