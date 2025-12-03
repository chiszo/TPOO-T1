/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;

import com.airpot.airport.t1poo.entidades.Puerta;
import com.airpot.airport.t1poo.interfaces.PuertaInterfazGestionDAO;
import com.airpot.airport.t1poo.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RIPCONCIV
 */
public class PuertaGestionDAO implements PuertaInterfazGestionDAO{

    @Override
    public ArrayList<Puerta> listarPuerta() {
       ArrayList<Puerta> lista = new ArrayList<>();

        String sql = "SELECT idpuerta, estado FROM puerta";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Puerta(
                    rs.getInt("idpuerta"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error listando la puerta: " + e.getMessage());
        }

        return lista;
    }
    
}
