/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import acceso.VehiculoDAO;
import modelo.Vehiculo;

/**
 *
 * @author Laura
 */
public class Servicio {
    
    private VehiculoDAO usdao;

    public Servicio() {
        this.usdao = new VehiculoDAO();
        
    }
    
    public Vehiculo encontrarVehiculo(String ced){
        Vehiculo v=null;
        if(usdao.BuscarVehiculo(ced)!=null)
            v= usdao.BuscarVehiculo(ced);
        return v;
    }
    
}