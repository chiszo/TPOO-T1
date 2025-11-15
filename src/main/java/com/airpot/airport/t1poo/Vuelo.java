
package com.airpot.airport.t1poo;


public class Vuelo {
    
    private String codigo;
    private String origen;
    private String destino;
    private int capacidad;
    private int ocupados = 0;
    private String puerta;  // NUEVO

    public Vuelo() {}

    public Vuelo(String codigo, String origen, String destino, int capacidad) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public int getOcupados() { return ocupados; }

    public String getPuerta() { return puerta; }
    public void setPuerta(String puerta) { this.puerta = puerta; }

    public boolean hayCupo() {
        return ocupados < capacidad;
    }

    public String asignarSiguienteAsiento() {
        if (!hayCupo()) return null;
        ocupados++;
        return "A" + ocupados;
    }

    @Override
    public String toString() {
        return codigo + " " + origen + "-" + destino +
                " (" + ocupados + "/" + capacidad + ")" +
                (puerta != null ? " Puerta:" + puerta : "");
    }
}
