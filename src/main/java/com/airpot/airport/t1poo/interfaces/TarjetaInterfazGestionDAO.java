/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.airpot.airport.t1poo.interfaces;

import com.airpot.airport.t1poo.entidades.TarjetaEmbarque;
import java.util.*;

/**
 *
 * @author RIPCONCIV
 */
public interface TarjetaInterfazGestionDAO {
    public ArrayList<TarjetaEmbarque> getDatosTarjetaEmbarque();
    
    public void insertData(int idpasajero,String asiento, int idpuerta);
    
    public void deleteData(int idtarjetaEmbarque);
}
