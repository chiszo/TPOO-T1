/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;

import com.airpot.airport.t1poo.entidades.Pasajero;
import com.airpot.airport.t1poo.entidades.PasajeroListado;
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
public class PasajeroGestionDAO implements PasajeroInterfazGestionDAO {

    @Override
    public int registrar(Pasajero o) {
        int res = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexion.getConexion();
            String sql = "insert into Pasajero (nombre,documento,telefono,idtipodocumento) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            //
            pstm.setString(1, o.getNombre());
            pstm.setString(2, o.getDocumento());
            pstm.setString(3, o.getTelefono());
            pstm.setInt(4, o.getIdtipodocumento());

            res = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error >>> en la instucción SQL de registrar " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    pstm.close();
                }
            } catch (SQLException e2) {
                System.out.println("Error al cerrar la BD" + e2.getMessage());
            }
        }

        return res;
    }

    @Override
    public int actualizar(Pasajero o) {
        int res = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexion.getConexion();
            String sql = "update pasajero set nombre= ? , documento=? ,telefono= ?, idtipodocumento= ? where idpasajero = ?";
            pstm = con.prepareStatement(sql);
            //
            pstm.setString(1, o.getNombre());
            pstm.setString(2, o.getDocumento());
            pstm.setString(3, o.getTelefono());
            pstm.setInt(4, o.getIdtipodocumento());
            pstm.setInt(5, o.getIdpasajero());
            res = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error >>> en la instucción SQL de actualizar " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    pstm.close();
                }
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
            String sql = "delete from pasajero where idpasajero = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigo);
            res = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error >>> en la instrucci�n SQL de eliminar " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    pstm.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar la BD" + e2.getMessage());
            }
        }

        return res;
    }

    @Override
    public Pasajero buscarPasajero(int codigo) {
        Pasajero p = null;
        PreparedStatement pstm = null;
        Connection con = null;
        ResultSet res = null;
        try {
            con = Conexion.getConexion();
            String sql = "select * from pasajero where idpasajero = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigo);
            res = pstm.executeQuery();
            if (res.next()) {
                p = new Pasajero(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
                        res.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(">>Error en la instrucción consultar pasajero " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (res != null) {
                    res.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
                System.out.println("Error al cerrar la bd " + e2.getMessage());
            }
        }
        return p;
    }

    @Override
    public ArrayList<Pasajero> listarPasajeros() {
        ArrayList<Pasajero> lista = new ArrayList<>();

        String sql = "SELECT idpasajero, nombre, documento, telefono, idtipodocumento FROM pasajero";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Pasajero(
                        rs.getInt("idpasajero"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("telefono"),
                        rs.getInt("idtipodocumento"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error listando los pasajeros: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public ArrayList<PasajeroListado> listarPasajeros2() {
        ArrayList<PasajeroListado> lista = new ArrayList<>();

        String sql = "CALL sp_listarpasajero()";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new PasajeroListado(
                        rs.getInt("idpasajero"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("telefono"),
                        rs.getString("descripcion"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error listando los pasajeros: " + e.getMessage());
        }

        return lista;
    }
    
    public boolean verificarExistenciaPasajero(int idpasajero){
        ArrayList<Pasajero> getData = new ArrayList<>();
        getData = listarPasajeros();
        
       for(Pasajero p : getData){
           if(p.getIdpasajero()== idpasajero) return true;
       }
       
       return false;
    }

}
