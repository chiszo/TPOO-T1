/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;
import com.airpot.airport.t1poo.entidades.Usuario;
import com.airpot.airport.t1poo.interfaces.UsuarioInterfazGestionDAO;
import com.airpot.airport.t1poo.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author RIPCONCIV
 */
public class UsuarioGestionDAO implements UsuarioInterfazGestionDAO{

    @Override
    public Usuario inicioSesion(String user, String clave) {
        Usuario usuario = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {
            con = Conexion.getConexion();
            String sql = "SELECT username, password, rol ,nombre FROM usuario WHERE username = ? AND password = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, clave);

            res = pstm.executeQuery();

        if (res.next()) {
            usuario = new Usuario(
                res.getString("username"),
                res.getString("password"),
                res.getString("rol"),
                res.getString("nombre")
            );
        }

    } catch (Exception e) {
        System.out.println("Error al validar el acceso: " + e.getMessage());

    } finally {
        try {
            if (res != null) res.close();
            if (pstm != null) pstm.close();
            if (con != null) con.close();

        } catch (SQLException e2) {
            System.out.println(">>> Error al cerrar la BD: " + e2.getMessage());
        }
    }

    return usuario;
    }
    
}
