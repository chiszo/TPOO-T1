/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.airpot.airport.t1poo.interfaces;

import com.airpot.airport.t1poo.entidades.Vuelo;
import com.airpot.airport.t1poo.entidades.VueloListado;
import java.util.ArrayList;

/**
 *
 * @author RIPCONCIV
 */
public interface VueloInterfazGestionDAO {
    public int registrar(Vuelo o);
    public int actualizar(Vuelo o);
    public int eliminar(int codigo);
    public Vuelo buscarVuelo(int codigo);
    public ArrayList<Vuelo> listarVuelo();
    public ArrayList<VueloListado> listarVuelos2();
}
