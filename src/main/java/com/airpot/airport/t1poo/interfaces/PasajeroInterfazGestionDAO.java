/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.airpot.airport.t1poo.interfaces;

import java.util.ArrayList;
import com.airpot.airport.t1poo.entidades.Pasajero;
/**
 *
 * @author RIPCONCIV
 */
public interface PasajeroInterfazGestionDAO {
    public int registrar(Pasajero o);
    public int actualizar(Pasajero o);
    public int eliminar(int codigo);
    public Pasajero buscarPasajero(int codigo);
    public ArrayList<Pasajero> listarPasajeros();
    public ArrayList<Pasajero> listarPasajeros2();
}
