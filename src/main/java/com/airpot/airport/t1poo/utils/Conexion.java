/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RIPCONCIV
 */
public class Conexion {
    public static void main(String[] args) {
        getConexion();
    }
    public static Connection getConexion(){
        Connection cn = null;
        String url = "jdbc:mysql://localhost:3306/aeropuerto";
        String user = "root";
        String pass = "admin";
        
        try {
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa a MySQL.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cn;
    }
}
