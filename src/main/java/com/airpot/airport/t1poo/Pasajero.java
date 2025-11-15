
package com.airpot.airport.t1poo;


public class Pasajero {
    private String id;
    private String nombre;
    private String documento;

    public Pasajero() {}

    public Pasajero(String id, String nombre, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDocumento(String documento) { this.documento = documento; }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + documento + ")";
    }
}
