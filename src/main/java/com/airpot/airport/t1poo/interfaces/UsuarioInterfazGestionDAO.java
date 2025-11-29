/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.airpot.airport.t1poo.interfaces;
import com.airpot.airport.t1poo.entidades.Usuario;
/**
 *
 * @author RIPCONCIV
 */
public interface UsuarioInterfazGestionDAO {
    public Usuario inicioSesion(String user, String clave);
}
