/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;

import com.airpot.airport.t1poo.entidades.Pasajero;
import com.airpot.airport.t1poo.interfaces.PasajeroInterfazGestionDAO;
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
public class PasajeroGestionDAO implements PasajeroInterfazGestionDAO{

    @Override
    public int registrar(Pasajero o) {
       int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexion.getConexion();
			String sql = "insert into pasajero (nombre,documento,telefono, idtipodocumento) values (?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//
			pstm.setString(1, o.getNombre());
			pstm.setString(2, o.getDocumento());
			pstm.setString(3, o.getTelefono());
			pstm.setInt(4, o.getIdtipodocumento());
			
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error >>> en la instucción SQL de registrar " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
    }

    @Override
    public int actualizar(Pasajero o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pasajero buscarPasajero(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pasajero> listarPasajeros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
