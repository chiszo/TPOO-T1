/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.entidades;

/**
 *
 * @author RIPCONCIV
 */
public class TipoDocumento {
    private int idtipodocumento;
    private String descripcion;

    public TipoDocumento(int idtipodocumento, String descripcion) {
        this.idtipodocumento = idtipodocumento;
        this.descripcion = descripcion;
    }

    public TipoDocumento() {
    }

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "idtipodocumento=" + idtipodocumento + ", descripcion=" + descripcion + '}';
    }
    
    
}
