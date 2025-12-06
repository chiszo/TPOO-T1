/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;


import com.airpot.airport.t1poo.entidades.TarjetaEmbarque;
import com.airpot.airport.t1poo.interfaces.TarjetaInterfazGestionDAO;
import com.airpot.airport.t1poo.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author RIPCONCIV
 */
public class TarjetaEmbqGestionDAO implements TarjetaInterfazGestionDAO {
    private ArrayList<TarjetaEmbarque> tarjEmbqData;
    
    public TarjetaEmbqGestionDAO(){
         tarjEmbqData = new ArrayList<>();
         cargarDatos();
    }
    
    @Override
    public ArrayList<TarjetaEmbarque> getDatosTarjetaEmbarque() {
        ArrayList<TarjetaEmbarque> listaTrjEmb = new ArrayList<>();
        TarjetaEmbarque trjEmbq = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {
            con = Conexion.getConexion();
            String sql = "SELECT idtarjetaEmbarque,idpasajero, idpuerta, asiento from TarjetaEmbarque";
            pstm = con.prepareStatement(sql);
            res = pstm.executeQuery();
            
            while(res.next()){
                listaTrjEmb.add(new TarjetaEmbarque(
                        res.getInt("idtarjetaEmbarque"),
                        res.getInt("idpasajero"),
                        res.getInt("idpuerta"),
                        res.getString("asiento")
                        
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener datos para la tabla Tarjeta Embarque: " + e.getMessage());

        } finally {
            try {
                if (res != null) res.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();

            } catch (SQLException e2) {
                System.out.println(">>> Error al cerrar la BD: " + e2.getMessage());
            }
        }
        
        return listaTrjEmb;
    }
    
    @Override
    public void insertData(int idpasajero,String asiento, int idpuerta){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        
        try{
            con = Conexion.getConexion();
            String sql = "INSERT INTO TarjetaEmbarque (idpasajero, asiento, idpuerta) VALUES (?, ?, ?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idpasajero);
            pstm.setString(2, asiento);
            pstm.setInt(3, idpuerta);
            
            int filasAfectadas = pstm.executeUpdate();
            
            System.out.println(filasAfectadas+" Filas afectadas correctamente");
        }
        catch(Exception e){
            System.out.println("Error al insertar datos para la tabla Tarjeta Embarque: " + e.getMessage());
        }
    }
    
    @Override
    public void deleteData(int idtarjetaEmbarque){
        try{
            Connection con = Conexion.getConexion();
            String sql = "DELETE FROM TarjetaEmbarque WHERE idtarjetaEmbarque = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, idtarjetaEmbarque);

            int fila = pstm.executeUpdate();
            
            System.out.println(fila+" Filas afectadas correctamente");
        }
        catch(Exception e){
            System.out.println("Error al eliminar datos para la tabla Tarjeta Embarque: " + e.getMessage());
        }
        
    }
    
    private void cargarDatos(){
        getData();
    }
    
    private ArrayList<TarjetaEmbarque> getData(){
        return getDatosTarjetaEmbarque();
    }
    
    public void agregarTarjetaEmbarque(int idTarjetaEmbarque, int idPasajero, int idPuerta, String asiento){
        TarjetaEmbarque trjEmbq = new TarjetaEmbarque(idTarjetaEmbarque,idPasajero,idPuerta,asiento);
        boolean verificadorExistencia = verificarTarjetaEmbarque(trjEmbq.getIdtarjetaEmbarque());
        if(!verificadorExistencia)tarjEmbqData.add(trjEmbq);
        else actualizarTarjetaEmbarque(trjEmbq);
        
        tarjEmbqData.stream().forEach(System.out::println);
    }
    
    private boolean verificarTarjetaEmbarque(int idTrjEmbq){
        for(TarjetaEmbarque te : tarjEmbqData){
            if(te.getIdtarjetaEmbarque()==idTrjEmbq) { System.out.println("Se encontro un objeto ya registrado!");return true;}
           
        }
        return false;
    }
    
    private void actualizarTarjetaEmbarque(TarjetaEmbarque te){
        tarjEmbqData.stream().forEach(trj->{
            if(trj.getIdtarjetaEmbarque()==te.getIdtarjetaEmbarque()){
                trj.setIdpasajero(te.getIdpasajero());
                trj.setAsiento(te.getAsiento());
                trj.setIdpuerta(te.getIdpuerta());
            }
        });
        
    }
    
    
    
    public boolean eliminarRegistroTarjetaEmbq(int idTrjEmbq){
        //tarjEmbqData=tarjEmbqData.stream().filter(t -> t.getIdtarjetaEmbarque()!=te.getIdtarjetaEmbarque()).collect(Collectors.toList());
        if(verificarTarjetaEmbarque(idTrjEmbq)){
            tarjEmbqData.removeIf(t-> t.getIdtarjetaEmbarque()==idTrjEmbq);
            return true;
        }
        return false;
    }
    
    

    
}
