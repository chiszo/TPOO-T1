/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;

import com.airpot.airport.t1poo.entidades.TipoDocumento;
import com.airpot.airport.t1poo.interfaces.TipoDocumentoInterfazGestionDAO;
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
public class TipoDocumentoGestionDAO implements TipoDocumentoInterfazGestionDAO{

    @Override
    public ArrayList<TipoDocumento> listarTipoDocumentos() {
         ArrayList<TipoDocumento> lista = new ArrayList<>();

        String sql = "SELECT idtipodocumento, descripcion FROM tipodocumento";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new TipoDocumento(
                    rs.getInt("idtipodocumento"),
                    rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error listando los tipo de documento: " + e.getMessage());
        }

        return lista;
    }
    
}
