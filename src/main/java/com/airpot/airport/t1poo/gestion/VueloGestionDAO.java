/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;

import com.airpot.airport.t1poo.entidades.Pasajero;
import com.airpot.airport.t1poo.entidades.PasajeroListado;
import com.airpot.airport.t1poo.entidades.Vuelo;
import com.airpot.airport.t1poo.entidades.VueloListado;
import com.airpot.airport.t1poo.interfaces.VueloInterfazGestionDAO;
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
public class VueloGestionDAO implements VueloInterfazGestionDAO{

    @Override
    public int registrar(Vuelo o) {
        int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexion.getConexion();
			String sql = "insert into vuelo (origen,destino,capacidad, ocupados, puerta) values (?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			//
			pstm.setString(1, o.getOrigen());
			pstm.setString(2, o.getDestino());
			pstm.setInt(3, o.getCapacidad());
			pstm.setInt(4, o.getOcupados());
			pstm.setInt(5, o.getIdpuerta());
                        
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
    public int actualizar(Vuelo o) {
        int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexion.getConexion();
			String sql = "update vuelo set origen= ? , destino=? ,capacidad= ?, ocupados= ?,puerta= ? where idvuelo = ?";
			pstm = con.prepareStatement(sql);
			//
			pstm.setString(1, o.getOrigen());
			pstm.setString(2, o.getDestino());
			pstm.setInt(3, o.getCapacidad());
			pstm.setInt(4, o.getOcupados());
			pstm.setInt(5,o.getIdpuerta());
                        pstm.setInt(6,o.getIdvuelo());
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error >>> en la instucción SQL de actualizar " + e.getMessage());
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
    public int eliminar(int codigo) {
        int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = Conexion.getConexion();
			String sql = "delete from vuelo where idvuelo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codigo);
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error >>> en la instrucci�n SQL de eliminar " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) pstm.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
    }

    @Override
    public Vuelo buscarVuelo(int codigo) {
       Vuelo p = null;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = Conexion.getConexion();
			String sql = "select * from vuelo where idvuelo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codigo);
			res = pstm.executeQuery();
			if (res.next()) {
				p = new Vuelo(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4),
						res.getInt(5), res.getInt(6));
			}
		} catch (Exception e) {
			System.out.println(">>Error en la instrucción consultar vuelo " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la bd " + e2.getMessage());
			}
		}
		return p;
    }

    @Override
    public ArrayList<Vuelo> listarVuelo() {
        ArrayList<Vuelo> lista = new ArrayList<>();

        String sql = "SELECT * FROM vuelo";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Vuelo(
                    rs.getInt("idvuelo"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getInt("capacidad"),
                    rs.getInt("ocupados"),
                    rs.getInt("puerta"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error listando los vuelos: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public ArrayList<VueloListado> listarVuelos2() {
            ArrayList<VueloListado> lista = new ArrayList<>();

        String sql = "CALL sp_listarvuelo()";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new VueloListado(
                    rs.getInt("idvuelo"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getInt("capacidad"),
                    rs.getInt("ocupados"),
                    rs.getString("puerta"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error listando los vuelos: " + e.getMessage());
        }

        return lista;
    }
    
}
