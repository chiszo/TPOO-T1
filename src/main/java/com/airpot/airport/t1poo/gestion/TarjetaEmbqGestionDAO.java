/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.airpot.airport.t1poo.gestion;


import com.airpot.airport.t1poo.entidades.TarjetaEmbarque;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author RIPCONCIV
 */
public class TarjetaEmbqGestionDAO {
    private ArrayList<TarjetaEmbarque> tarjEmbqData;
    
    public TarjetaEmbqGestionDAO(){
         tarjEmbqData = new ArrayList<>();
         cargarDatos();
    }
    
    private void cargarDatos(){
        tarjEmbqData.add(new TarjetaEmbarque(01,01,01,"A01"));
    }
    
    public ArrayList<TarjetaEmbarque> getData(){
        return tarjEmbqData;
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
