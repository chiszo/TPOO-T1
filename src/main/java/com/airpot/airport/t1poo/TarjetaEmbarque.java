
package com.airpot.airport.t1poo;


public class TarjetaEmbarque {
      private String pasajeroId;
    private String pasajeroNombre;
    private String vueloCodigo;
    private String asiento;
    private String puerta;

    public TarjetaEmbarque() {}

    public TarjetaEmbarque(String pasajeroId, String pasajeroNombre,
                           String vueloCodigo, String asiento, String puerta) {
        this.pasajeroId = pasajeroId;
        this.pasajeroNombre = pasajeroNombre;
        this.vueloCodigo = vueloCodigo;
        this.asiento = asiento;
        this.puerta = puerta;
    }

    public String getPasajeroId() { return pasajeroId; }
    public void setPasajeroId(String pasajeroId) { this.pasajeroId = pasajeroId; }

    public String getPasajeroNombre() { return pasajeroNombre; }
    public void setPasajeroNombre(String pasajeroNombre) { this.pasajeroNombre = pasajeroNombre; }

    public String getVueloCodigo() { return vueloCodigo; }
    public void setVueloCodigo(String vueloCodigo) { this.vueloCodigo = vueloCodigo; }

    public String getAsiento() { return asiento; }
    public void setAsiento(String asiento) { this.asiento = asiento; }

    public String getPuerta() { return puerta; }
    public void setPuerta(String puerta) { this.puerta = puerta; }

    @Override
    public String toString() {
        return "BOARDING PASS | " + pasajeroNombre +
               " | Vuelo " + vueloCodigo +
               " | Asiento " + asiento +
               " | Puerta " + puerta;
    }
}
