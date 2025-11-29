/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.entidades;

/**
 *
 * @author Chiszo
 */
public class PasajeroListado {
    private int idpasajero;
    private String nombre;
    private String documento;
    private String telefono;
    private String tipodocumento;

    public PasajeroListado() {
    }

    public PasajeroListado(int idpasajero, String nombre, String documento, String telefono, String tipodocumento) {
        this.idpasajero = idpasajero;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.tipodocumento = tipodocumento;
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

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
}
