
package com.airpot.airport.t1poo;


public class Puerta {
     private String codigo;
    private boolean abierta;

    public Puerta() {}

    public Puerta(String codigo) {
        this.codigo = codigo;
        this.abierta = false; // por defecto cerrada
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public boolean isAbierta() { return abierta; }
    public void abrir() { this.abierta = true; }
    public void cerrar() { this.abierta = false; }

    @Override
    public String toString() {
        return "Puerta " + codigo + " [" + (abierta ? "ABIERTA" : "CERRADA") + "]";
    }
}
