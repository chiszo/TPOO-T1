
package com.airpot.airport.t1poo;


public class Pasajero {
    private int idpasajero;
    private String nombre;
    private String documento;
    private String telefono;
    private int idtipodocumento;

    public Pasajero() {}

    public Pasajero(int idpasajero, String nombre, String documento, String telefono, int idtipodocumento) {
        this.idpasajero = idpasajero;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.idtipodocumento = idtipodocumento;
    }

    public int getIdpasajero() {
        return idpasajero;
    }

    public void setIdpasajero(int idpasajero) {
        this.idpasajero = idpasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "idpasajero=" + idpasajero + ", nombre=" + nombre + ", documento=" + documento + ", telefono=" + telefono + ", idtipodocumento=" + idtipodocumento + '}';
    }

}
