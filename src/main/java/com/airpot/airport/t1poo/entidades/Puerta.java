
package com.airpot.airport.t1poo.entidades;


public class Puerta {
    private int idpuerta;
    private boolean estado;

    public Puerta() {}

    public Puerta(int idpuerta, boolean estado) {
        this.idpuerta = idpuerta;
        this.estado = estado;
    }    
    

    public int getIdpuerta() {
        return idpuerta;
    }

    public void setIdpuerta(int idpuerta) {
        this.idpuerta = idpuerta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Puerta{" + "idpuerta=" + idpuerta + ", estado=" + estado + '}';
    }
}
